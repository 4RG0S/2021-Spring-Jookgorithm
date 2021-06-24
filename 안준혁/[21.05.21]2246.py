import sys

n = int(sys.stdin.readline())

number = list(map(int, sys.stdin.readline().split()))

k = int(sys.stdin.readline())

count = 0

for i in range(n):
    tempSum = 0
    for j in range(i, n):
        tempSum += number[j]
        if tempSum > k:
            count += (n - j)
            break

print(count)
