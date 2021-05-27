n, m = map(int, input().split())
a = list(map(int, input().split()))
start, end = 0, 0
s = 0
count = 0
while start != n and end != n+1:
    if s >= m:
        if s == m:
            count += 1
        s -= a[start]
        start += 1
    else:
        if end == n:
            break
        s += a[end]
        end += 1
print(count)