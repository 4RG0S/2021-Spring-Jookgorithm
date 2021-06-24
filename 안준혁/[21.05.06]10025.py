import sys

n, k = map(int, sys.stdin.readline().split())

ice = [0]*1000001

left = sys.maxsize
right = 0

for _ in range(n):
    g, x = map(int, sys.stdin.readline().split())
    left = min(x, left)
    right = max(x, right)
    ice[x] = g

answer = 0

for i in range(left, right+1):
    sum = 0
    start = i - k
    if i - k < left:
        start = left
    end = i + k
    if i + k > right:
        end = right
    for j in range(start, end + 1):
        sum += ice[j]
    answer = max(answer, sum)
    if i + k > right:
        break

print(answer)