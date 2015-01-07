from math import factorial

"""
l = "1111111111111111111100000000000000000000"
count = 0
for perm in itertools.permutations(l):
    count += 1
print count / len(l)
"""

grid = 20
print factorial(grid * 2) / factorial(grid)**2
