import math


for i in range(10000, 2000000):
    triangle = i*(i+1) / 2
    divisors = 0
    square = int(math.sqrt(triangle))
    for j in xrange(1, square):
        if triangle % j == 0:
            divisors += 2

    if square * square == triangle:
        divisors -= 1
            
    if divisors > 500:
        print i, triangle
        exit()
