n = int(input())
start, end = 1, 1
s, count = 1, 0
while start <= n and end <= n:
    if s >= n:
        if s == n:
            count += 1
        s -= start
        start += 1
    else:
        end += 1
        s += end
print(count)