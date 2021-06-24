import sys

n, m = map(int, sys.stdin.readline().split())

eggs = []

for _ in range(m):
    eggs.append(int(sys.stdin.readline().strip()))

eggs.sort()
eggs.reverse()

revenue = eggs[0]

if n < m:
    for i in range(n):
        currentPrice = eggs[i]
        currentRevenue = eggs[i] * (i + 1)
        if currentRevenue > revenue:
            price = currentPrice
            revenue = currentRevenue
else:
    for i in range(m):
        currentPrice = eggs[i]
        currentRevenue = eggs[i] * (i + 1)
        if currentRevenue > revenue:
            price = currentPrice
            revenue = currentRevenue

print(price, revenue)