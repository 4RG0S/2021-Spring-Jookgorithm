input()
b = list(map(int, input().split()))

ar = [0] * (max(b) + 1)

for i in b:
    if ar[i] > 0:
        ar[i] -= 1
        ar[i - 1] += 1
    else:
        ar[i - 1] += 1

a = 0
for i in ar:
    a += i
print(a)
