import sys
read = sys.stdin.readline
n = int(read())
participant = {}
for _ in range(n):
    name = read().rstrip()
    participant[name] = participant.get(name, 0) + 1
for _ in range(n-1):
    name = read().rstrip()
    participant[name] -= 1
for i in participant:
    if participant[i] == 1:
        print(i)