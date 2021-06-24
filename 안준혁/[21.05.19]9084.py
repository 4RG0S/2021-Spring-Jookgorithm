import sys

t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    items = list(map(int, sys.stdin.readline().split()))
    money = int(sys.stdin.readline())
    weights = []
    weights = [0] * (money + 1)
    weights[0] = 1
    for item in items:
        for j in range(item, money+1):
            weights[j] += weights[j - item]
    print(weights[money])
