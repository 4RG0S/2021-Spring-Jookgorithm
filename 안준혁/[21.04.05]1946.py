import sys

t = int(sys.stdin.readline().rstrip())

for _ in range (t):
    n = int(sys.stdin.readline().rstrip())

    persons = sorted(list(list(map(int, sys.stdin.readline().rstrip().split())) for i in range(n)))

    minScore = persons[0][1]
    cnt = 1

    for person in persons:
        if minScore > person[1]:
            minScore = person[1]
            cnt += 1

    print(cnt)