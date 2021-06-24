import sys

n = list(sys.stdin.readline().strip())
n.sort(reverse=True)

sum = 0

for i in n:
    sum += int(i)

if sum % 3 == 0 and "0" in n:
    print("".join(n))
else:
    print(-1)
