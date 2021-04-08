import sys
read = sys.stdin.readline
wait = {}
queue = {}
k, n = map(int, read().split())
for i in range(n):
    num = read().rstrip()
    wait[num] = i

for i in wait:
    queue[wait[i]] = i
for i in sorted(queue)[:k]:
    print(queue[i])