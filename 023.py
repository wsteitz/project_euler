import math
abundant = []
limit = 28123

numbers = {}
for n in range(limit):
    numbers[n] = False


for n in range(12, limit):
    sqrt = int(math.sqrt(n))
    div_sum = 1 + sum([i + n / i for i in range(2, sqrt + 1) if n % i == 0])
    if sqrt * sqrt == n:
        div_sum -= sqrt

    if div_sum > n:
        abundant.append(n)

        for n2 in abundant:
            numbers[n + n2] = True

print sum([n for n in numbers.keys() if not numbers[n]])
