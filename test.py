from __future__ import division
import os
import subprocess
import time
import termcolor
import argparse


results = { 1: '233168',
            2: '4613732',
            4: '906609',
            6: '25164150',
            7: '104743',
            8: '23514624000',
            9: '31875000',
           10: '142913828922',
           11: '70600674',
           12: '76576500',
           13: '5537376230',
           14: '837799',
           15: '137846528820',
           16: '1366',
           17: '21124',
           18: '1074',
           19: '171',
           20: '648',
           21: '31626',
           22: '871198282',
           23: '4179871',
           24: '2783915460',
           25: '4782',
           26: '983',
           27: '-59231',
           28: '669171001',
           29: '9183',
           30: '443839',
           31: '73682',
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

def main(problem_number):
    filenames = os.listdir(".")
    solutions = [f for f in filenames if is_number((f.split('.')[0]))]
    stats = []

    for sol in sorted(solutions):
        number, lang = sol.split('.')
        if (problem_number is not None
            and int(number) != int(problem_number)):
            continue

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
