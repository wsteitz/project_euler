n = 100

s = 0
for i in range(n+1):
    s += i**2

print sum(range(n+1))**2 - s
