import sys
from functools import cmp_to_key


def compare(a, b):
    if len(a) < len(b):
        return -1
    elif len(b) < len(a):
        return 1
    else:
        sumA = 0
        sumB = 0
        for i in range(len(a)):
            if a[i].isdigit():
                sumA += int(a[i])
        for i in range(len(b)):
            if b[i].isdigit():
                sumB += int(b[i])
        if sumA < sumB:
            return -1
        elif sumB < sumA:
            return 1
        else:
            for i in range(len(a)):
                if a[i] < b[i]:
                    return -1
                elif a[i] > b[i]:
                    return 1

n = int(sys.stdin.readline())

numbers = []

for _ in range(n):
    numbers.append(sys.stdin.readline().strip())

numbers = sorted(numbers, key=cmp_to_key(compare))

print('\n'.join(numbers))