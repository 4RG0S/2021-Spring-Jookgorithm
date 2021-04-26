import math

G = int(input())
p = []

for m in range(1, int((G - 1) / 2) + 2):
    c = math.sqrt(G + math.pow(m, 2))
    if c % 1 == 0:
        p.append(int(c))
if len(p) == 0:
    print(-1)
else:
    for i in p:
        print(i)
