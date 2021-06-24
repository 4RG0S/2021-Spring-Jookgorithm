import sys

n = int(sys.stdin.readline())

cows = sorted(list(map(int, sys.stdin.readline().split())) for _ in range(n))

time = 0

for cow in cows:
    if cow[0] > time:
        time = cow[0]+cow[1]
    else:
        time += cow[1]

print(time)