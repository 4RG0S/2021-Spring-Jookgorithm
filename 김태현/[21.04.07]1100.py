answer = 0
for i in range(1, 9):
    a = input()
    if i % 2 == 0:
        for j in range(1, len(a) + 1):
            if j % 2 == 0 and a[j - 1] == 'F':
                answer += 1
    else:
        for j in range(1, len(a) + 1):
            if j % 2 == 1 and a[j - 1] == 'F':
                answer += 1
print(answer)