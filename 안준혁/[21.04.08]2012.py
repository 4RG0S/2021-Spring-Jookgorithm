import sys

n = int(sys.stdin.readline())

list = [int(sys.stdin.readline()) for _ in range(n)]

list.sort()

sum = 0

for i in range(n):
    if list[i] - i - 1 > 0:
        sum += list[i] - i - 1
    else:
        sum += i + 1 - list[i]