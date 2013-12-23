import datetime

one_day = datetime.timedelta(days=1)
start = datetime.date(1901, 1, 1)
end = datetime.date(2000, 12, 31)

count = 0
while start <= end:
    if start.day == 1 and start.isoweekday() == 7:
        count += 1
    start += one_day

print count
