maximum = 0
max_start = 0

for start in range(2, 1000000):
    count = 1
    n = start
    while n>1:
        count += 1
        if n % 2 == 0:
            n /= 2
        else:
            n = 3 * n + 1
    if count > maximum:
        maximum = count
        max_start = start


print max_start, maximum
