from tools import is_prime

best = 0
for a in range(-1000, 1000):
    for b in range(-1000, 1000):
        running = True
        n = 0
        while running:
            num = n * n + a * n  + b
            if is_prime(num):
                n += 1
            else:
                if n >= best:
                    print n, a, b, a*b
                    best = n
                running = False
