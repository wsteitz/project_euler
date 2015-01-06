
def is_prime(n):
    for x in range(3, int(n**0.5)+1, 2):
        if n % x == 0:
            return False
    return True


n = 2000000
res = 2
for i in range(3, n, 2):
    if is_prime(i):
        print i
        res += i

print "result", res
