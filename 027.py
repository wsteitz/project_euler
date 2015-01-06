def is_prime(n):
    if n < 0:
        return False
    for x in range(3, int(n**0.5)+1, 2):
        if n % x == 0:
            return False
    return True


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
