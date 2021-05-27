n, m = map(int, input().split())
a = list(map(int, input().split()))
start, end = 0, 0
s = 0
length = []
while start != n and end != n+1:
    if s >= m:
        length.append(end-start)
        s -= a[start]
        start += 1
    else:
        if end == n:
            break
        s += a[end]
        end += 1
if len(length):
    print(min(length))
else:
    print(0)