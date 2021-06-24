import sys

n, c = map(int, sys.stdin.readline().split())

messagenger = list(sys.stdin.readline().split())

counter = {}

for message in messagenger:
    if message in counter:
        counter[message] += 1
    else:
        counter[message] = 1

answer = sorted(counter.items(), key=lambda x: x[1], reverse=True)

for num in answer:
    for _ in range(num[1]):
        print(num[0], end=' ')