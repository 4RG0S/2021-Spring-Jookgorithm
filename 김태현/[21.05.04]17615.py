input()
c = list(input())

rb = [0, 0]

for i in c:
    if i == "R":
        rb[0] += 1
    else:
        rb[1] += 1

erb = [0, 0, 0, 0]

for i in range(1, len(c)):
    if c[i] is not c[i - 1]:
        if c[i - 1] == "R":
            erb[0] = i
        else:
            erb[1] = i
        break

for i in range(1, len(c)):
    if c[len(c) - i] is not c[len(c) - i - 1]:
        if c[len(c) - i] == "R":
            erb[2] = i
        else:
            erb[3] = i
        break

r = 0
b = 0
if erb[0] >= erb[2]:
    r = rb[0] - erb[0]
else:
    r = rb[0] - erb[2]

if erb[1] >= erb[3]:
    b = rb[1] - erb[1]
else:
    b = rb[1] - erb[3]

if r <= b:
    print(r)
else:
    print(b)
