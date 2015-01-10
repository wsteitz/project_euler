for a in range(300):
    for b in range(a, 500):
        for c in range(b, 500):
            if a + b + c == 1000 and a * a + b * b == c * c:
                print a, b, c, a * b * c
                exit()
