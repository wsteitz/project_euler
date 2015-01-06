
fib = {1: 1, 2: 1}
for i in range(3, 10000):
    fib[i] = fib[i-1] + fib[i-2]
    if len(str(fib[i])) >= 1000:
        print i, fib[i]
        exit()
