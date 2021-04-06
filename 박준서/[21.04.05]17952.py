import sys
read = sys.stdin.readline
stack = []
score = 0
n = int(read())
for _ in range(n):
    line = read()
    line = list(map(int, line.split()))
    if line[0] != 0:
        if line[2] == 1:
            score += line[1]
            continue
        stack.append(line)
    if len(stack) > 0:
        stack[-1][2] -= 1
        if stack[-1][2] == 0:
            score += stack.pop()[1]
print(score)