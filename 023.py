

abundant = []

numbers = {}
for n in range(28123):
	numbers[n] = False


for n in range(1, 28123):
	div_sum = sum([i for i in range(1, n/2+1) if n % i == 0])
	if div_sum > n:
		abundant.append(n)
		for n2 in abundant:
			numbers[n + n2] = True
		

print sum([n for n in numbers.keys() if not numbers[n]])
