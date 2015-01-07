to_twenty = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine', 'ten',
            'eleven', 'twelve', 'thirteen', 'fourteen', 'fivteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen']

tens = ['twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']


def print_number(i, string=""):
    if i==0:
        return string
    elif i < 20:
        return string + ' ' + to_twenty[i]
    elif i < 100:
        return tens[i / 10 - 2] + print_number(i % 10)
    elif i < 1000:
        if i % 100 != 0:
            return to_twenty[i / 100] + ' hundred and ' + print_number(i % 100)
        else:
            return to_twenty[i / 100] + ' hundred'
    else:
        return to_twenty[i / 1000] + ' thousand ' + print_number(i % 1000)


count = 0
for i in range(1, 1001):
    print i, print_number(i)
    count += len(print_number(i).replace(" ", ""))

print print_number(1000)
print count
