import sys
read = sys.stdin.readline
n, k = map(int, read().split())
coins = []
ans = 0
for _ in range(n):
    coin = int(read())
    coins.append(coin)
for i in coins[::-1]:
    if k == 0:
        break
    ans += k//i
    k = k%i
print(ans)