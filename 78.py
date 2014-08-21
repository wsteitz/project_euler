cache = [1]

n = 1


while True:
    i = 0
    pentagonal = 1
    cache.append(0)

    while (pentagonal <= n):
        sign = -1 if (i % 4 > 1)  else 1
        cache[n] += sign * cache[n - pentagonal]
        cache[n] %= 1000000
        i += 1
        j = i / 2 + 1 if (i % 2 == 0)  else -(i / 2 + 1)
        pentagonal = j * (3 * j - 1) / 2

    if (cache[n] == 0):
        print n
        break
    n += 1
