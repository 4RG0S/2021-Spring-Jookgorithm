import sys

n = sys.stdin.readline()

a, b  = {}, {}

for i in map(int, sys.stdin.readline().split()):
    a[i] = 1
for i in map(int, sys.stdin.readline().split()):
    b[i] = 1

c = []

for number in a:
    if number not in b:
        c.append(number)

print(len(c))

print(*sorted(c))


