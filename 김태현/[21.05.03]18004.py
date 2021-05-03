A, B = map(int, input().split())

answer = 0

while True:
    if A <= B:
        answer += B - A
        break
    if A > B:
        if A % 2 == 0:
            A /= 2
            answer += 1
        else:
            A = (A + 1) / 2
            answer += 2

print(int(answer))
