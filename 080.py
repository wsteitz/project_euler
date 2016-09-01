from math import sqrt
from decimal import Decimal, getcontext

getcontext().prec = 105

total = 0
for a in range(100):
    if not sqrt(a) % 1 == 0:
        digits = str(Decimal(a).sqrt()).replace('.', '')[:100]
        total += sum(map(int, digits))

print total
