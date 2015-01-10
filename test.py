from __future__ import division
import os
import subprocess
import time
import termcolor
import argparse
import urllib2


SLOW_THRESHOLD = 10


def get_results():
    url = "https://code.google.com/p/projecteuler-solutions/wiki/ProjectEulerSolutions"
    data = urllib2.urlopen(url).read()
    # realy lame way to parse the html.. it works
    filtered = data[data.find("1. "):data.find("</p><p></pre> </p>")]

    items = [s.strip().split(" ") for s in filtered.replace(".", "").split("\n")]
    items = [item for item in items if len(item) == 2]
    with open("results.csv", 'w') as fout:
        for num, value in items:
            print >> fout, ",".join([num, value.strip().replace(",", "")])


def load_results():
    if not os.path.exists("results.csv"):
        get_results()
    results = {}
    with open("results.csv") as fin:
        for row in fin:
            num, res = row.strip().split(",")
            results[int(num)] = res
    return results


def is_number(s):
    try:
        float(s)
        return True
    except ValueError:
        return False


def setup():
    print "compiling and packaging scala sources"
    subprocess.call(["sbt", "assembly"])


def parse_result(raw):
    """ scripts may output lots of information. by convention, the last
        string is regarded as the solution"""
    last_line = raw.strip().split("\n")[-1]
    result = last_line.replace("\t", " ").split()[-1]
    return result


def print_row(sol, success, elapsed):
    if success is None: col = 'blue'
    elif success: col = 'green'
    else: col = 'red'
    sol_string = termcolor.colored(sol, col)

    col = 'red' if elapsed > SLOW_THRESHOLD else 'green'
    elapsed_string = termcolor.colored( "%0.3fs" % elapsed, col)

    print "{: <20} {}".format(sol_string, elapsed_string)


def print_stats(stats):
    print "--------------"
    print "{: <12} {}".format('# solutions', len(stats))
    print "{: <12} {}".format('# unique', len(set([s[0] for s in stats])))
    wrong_count = len(stats) - sum([s[2] for s in stats])
    print "{: <12} {} - {}%".format('# wrong', wrong_count, "%0.2f" % (100 * wrong_count / len(stats)))
    slow_count = sum([1 for s in stats if s[3] > SLOW_THRESHOLD])
    print "{: <12} {} - {}%".format('# slow', slow_count, "%0.2f" % (100 * slow_count / len(stats)))
    tot_time = sum([s[3] for s in stats])
    print "{: <12} {}s".format('total time', "%0.2f" % tot_time)
    print "{: <12} {}s".format('avg time', "%0.2f" % (tot_time / len(stats)))


def main(problem_number):
    results = load_results()
    filenames = os.listdir(".")
    solutions = [f for f in filenames if is_number((f.split('.')[0]))]
    stats = []

    for sol in sorted(solutions):
        number, lang = sol.split('.')
        if (problem_number is not None
            and int(number) != int(problem_number)):
            continue

        if lang == 'py':
            command = ['python', sol]
        elif lang == 'scala':
            #command = ['scala', '-cp', 'target/scala-2.10/classes',  'euler.Euler%s' % number]
            # use jar, because that includes the scala version used by sbt
            command = ['java',
                       '-cp', 'target/scala-2.11/euler-assembly-0.1.jar',
                       'euler.Euler%s' % number]
        else:
            print "WARNING unknown language", lang
            continue

        start = time.time()
        try:
            raw_result = subprocess.check_output(command)
        except subprocess.CalledProcessError:
            print "ERROR failed to run", sol
            continue
        elapsed = time.time() - start
        result = parse_result(raw_result)
        success = results[int(number)] == result if int(number) in results else None
        print_row(sol, success, elapsed)
        stats.append([number, lang, success, elapsed])

    print_stats(stats)


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('problem_number', nargs='?', default=None)
    parser.add_argument('--nosetup', action='store_true', default=False)
    args = parser.parse_args()

    if not args.nosetup:
        setup()
    main(args.problem_number)
