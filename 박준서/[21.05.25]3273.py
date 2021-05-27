import sys
read = sys.stdin.readline
n = int(read())
a = sorted(list(map(int, read().split())))
x = int(read())

start, end = 0, n-1
count = 0
while start < end:
    s = a[start] + a[end]
    if s == x:
        count += 1
        start += 1
        end -= 1
    elif s < x:
        start += 1
    else:
        end -= 1
print(count)