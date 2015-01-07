


def collatz(n):
    if not n in mem:
        if n % 2 == 0:
            mem[n] = collatz(n // 2) + 1
        else:
            mem[n] = collatz(3 * n + 1) + 1
    return mem[n]

mem = {1: 1}
current_max = 0
res = 0
for i in range(1000000, 1, -1):
    cl = collatz(i)
    if cl > current_max:
        current_max = cl
        res = i

print res
