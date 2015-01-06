
digits = 3
maximum = 0

for i in range(10**(digits-1), 10**digits):
    for j in range(10**(digits-1), 10**digits):
        n = i * j
        chars = str(n)
        if n > maximum and (chars == chars[::-1]):
            maximum = n

print maximum
    
