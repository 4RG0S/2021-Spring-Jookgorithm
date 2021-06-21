def find(a, k, i):
    n = len(a)
    start, end = 0, n - 1
    while start < end:
        if end == i:
            end -= 1
            continue
        if start == i:
            start += 1
            continue
        s = a[start] + a[end]
        if s == k:
            return 1
        if s > k:
            end -= 1
        else:
            start += 1

    return 0

n = input()
a = sorted(list(map(int, input().split())))
count = 0
for i in range(len(a)):
    count += find(a, a[i], i)
print(count)