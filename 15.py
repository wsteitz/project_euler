import itertools



def fakult(n):
    #Für Re- hat die Fakultät keine Wertemenge
    if n < 0:
        raise ValueError
    #Nach Definition ist 0! = 1
    if n == 0:
        return 1
    #Ansonten wird hier die Fakultät ausgerechnet
    else:
        save = 1
        for i in range(2,n+1):
            save *= i
        return save



print 



l = "1111111111111111111100000000000000000000"
count = 0
for perm in itertools.permutations(l):
    count += 1
print count / len(l)



