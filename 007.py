from tools import is_prime

i = 3
count = 2

while count < 10001:
    i += 2
    if is_prime(i):
        count += 1

print i


