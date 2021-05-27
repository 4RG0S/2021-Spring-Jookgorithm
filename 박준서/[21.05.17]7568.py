import sys
read = sys.stdin.readline
n = int(read())
people = []
rank = [1 for _ in range(n)]
for _ in range(n):
    x, y = map(int, read().split())
    people.append((x, y))
for i in range(n):
    for j in range(n):
        if i == j:
            continue
        if people[i][0] < people[j][0] and people[i][1] < people[j][1]:
            rank[i] += 1
print(' '.join(list(map(str, rank))))