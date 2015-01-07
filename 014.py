
def collatz(n):
    if n <= 1:
        return 1
    elif n % 2 == 0:
        return n // 2
    else:
        return 3 * n + 1


def collatz_length(n):
    length = 1
    next_val = collatz(n)
    while n != 1:
        n = collatz(n)
        length += 1
    return length


limit = 1000000
print max([(collatz_length(n), n) for n in range(limit)])[1]
