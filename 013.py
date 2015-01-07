
with open('data/13.dat', 'r') as fin:
    res = 0
    for row in fin:
        res += int(row)

print str(res)[:10]
