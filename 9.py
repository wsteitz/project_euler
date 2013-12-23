for a in range(500):
    print a
    for b in range(500):
        for c in range(500):
            if a + b + c == 1000 and b > a and c > b:
                if a*a + b*b == c*c:
                    print a, b, c, a*b*c
                    exit()
