
def is_pandigital(i):
    count = 10 * [False]
    while i != 0:
        d = i % 10
        if d == 0 or count[d]:
            return False
        count[d] = True
        i /= 10
    return True


def search():
    last_2, last_1 = 1, 2
    k = 3
    while True:
        last_2, last_1 = last_1, last_1 + last_2
        k += 1
        if last_1 >= 100000000 and is_pandigital(last_1 % 1000000000) and is_pandigital(int(str(last_1)[:9])):
            return k


print search()
