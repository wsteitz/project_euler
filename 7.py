
def is_prime(n):
    for x in range(3, int(n**0.5)+1, 2):
        if n % x == 0:
            return False
    return True




i = 3
count = 2

while count < 10001:
    i += 2
    if is_prime(i):
        count += 1

print i

    
