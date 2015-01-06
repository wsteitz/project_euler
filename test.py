from __future__ import division
import os
import subprocess
import time
import termcolor


results = {'001': '233168',
           '002': '4613732',
           '004': '906609',
           '006': '25164150',
           '007': '104743',
           '008': '23514624000',
           '009': '31875000',
           '010': '142913828922',
           '011': '70600674',
           '012': '76576500',
           }
SLOW_THRESHOLD = 10


def is_number(s):
    try:
        float(s)
        return True
    except ValueError:
        return False


def setup():
    print "compiling scala sources"
    subprocess.call("sbt compile", shell=True)


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

def main():
    setup()
    filenames = os.listdir(".")
    solutions = [f for f in filenames if is_number((f.split('.')[0]))]
    stats = []

    for sol in sorted(solutions)[:10]:
        number, lang = sol.split('.')
        if lang == 'py':
            command = 'python %s' % sol
        elif lang == 'scala':
            command = 'scala -cp target/scala-2.10/classes euler.Euler%s' % number
        else:
            print "WARNING unknown language", lang
            continue

        start = time.time()
        try:
            raw_result = subprocess.check_output(command, shell=True)
        except subprocess.CalledProcessError:
            print "ERROR failed to run", sol
            continue
        elapsed = (time.time() - start)
        result = parse_result(raw_result)
        success = results[number] == result if number in results else None
        print_row(sol, success, elapsed)
        stats.append([number, lang, success, elapsed])

    print_stats(stats)



if __name__ == '__main__':
    main()
