import sys
read = sys.stdin.readline
t = int(read())
for _ in range(t):
    ans = {}
    read()
    memo1 = list(map(int, read().split()))
    for i in memo1:
        ans[i] = 1
    read()
    memo2 = list(map(int, read().split()))
    for i in memo2:
        print(ans.get(i, 0))