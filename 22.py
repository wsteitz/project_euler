
score = 0
with open("names.txt", 'r') as fin:
    i = 0
    for name in sorted(fin.read().replace('"', '').split(',')):
        i += 1
        res = 0
        for char in name:
            res += ord(char) - 64
        res *= i
        score += res
    

print score
