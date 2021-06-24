import sys

n = int(sys.stdin.readline())

numbers = list(map(int, sys.stdin.readline().split()))

numbers.sort()

sum = []

for i in range(n):
    sum.append(numbers[i] + numbers[2*n - 1 - i])

print(min(sum))