
div_sums = {}
res = 0
for n in range(1, 10000):
    div_sum = sum([i for i in range(1, n / 2 + 1) if n % i == 0])
    if div_sum in div_sums and div_sums[div_sum] == n:
        res += n + div_sum

    div_sums[n] = div_sum

print res
