import sys
read = sys.stdin.readline
k = int(read())
stack = []
for _ in range(k):
    n = int(read())
    if n == 0:
        stack.pop()
    else:
        stack.append(n)
print(sum(stack))