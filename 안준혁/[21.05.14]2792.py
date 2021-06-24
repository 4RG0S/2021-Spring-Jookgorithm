import sys
import math

n, m = map(int, sys.stdin.readline().split())

jewelries = []

for _ in range(m):
    jewelries.append(int(sys.stdin.readline()))

left = 1
right = max(jewelries)
answer = right

while left <= right:
    count = 0
    mid = (left + right) // 2
    for jewerly in jewelries:
        count += math.ceil(jewerly / mid)
        if count > n:
            left = mid + 1
            break
    if count <= n:
        answer = min(mid, answer)
        right = mid - 1

print(answer)
