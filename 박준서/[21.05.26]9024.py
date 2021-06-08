import sys
read = sys.stdin.readline
t = int(read())
for _ in range(t):
    n, k = map(int, read().split())
    a = sorted(list(map(int, read().split())))
    m = float('inf')
    nearest = {}

    start, end = 0, n-1
    count = 0
    while start < end:
        s = a[start] + a[end]
        diff = abs(s-k)
        nearest[diff] = nearest.get(diff, 0) + 1
        if diff < m:
            m = diff
        if s == k:
            start += 1
            end -= 1
        elif s < k:
            start += 1
        else:
            end -= 1
    print(nearest[m])

'''
4
10 8
-7 9 2 -4 12 1 5 -3 -2 0
10 4
-7 9 2 -4 12 1 5 -3 -2 0
4 20
1 7 3 5
5 10
3 9 7 1 5
'''