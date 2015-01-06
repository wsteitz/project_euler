def is_palindrom(n):
    chars = str(n)
    return (chars == chars[::-1])

res = 0
for i in range(1000000):
    if is_palindrom(i) and is_palindrom(bin(i)[2:]):
        res += i

print res
