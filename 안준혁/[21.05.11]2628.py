import sys

n, m = map(int, sys.stdin.readline().split())

again = int(sys.stdin.readline())

row = [0, n]
column = [0, m]

for i in range(again):
    where, number = map(int, sys.stdin.readline().split())
    if where == 1:
        row.append(number)
    else:
        column.append(number)

row.sort()
column.sort()

rowMax = 0
columnMax = 0

for i in range(1, len(row)):
    rowMax = max(row[i] - row[i - 1], rowMax)

for i in range(1, len(column)):
    columnMax = max(column[i] - column[i - 1], columnMax)

print(rowMax*columnMax)