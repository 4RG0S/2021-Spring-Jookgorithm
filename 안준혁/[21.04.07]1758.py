import sys

n = int(sys.stdin.readline())

list = [int(sys.stdin.readline()) for _ in range(n)]

list.sort()

list.reverse()

sum = 0

for i in range(n):
    if list[i] - i > 0:
        sum += list[i] - i
    else:
        break

print(sum)