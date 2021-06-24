import sys

n = int(sys.stdin.readline())

s = ""

numbers = []

for _ in range(n):
    temp = sys.stdin.readline().strip()
    for i in range(len(temp)):
        if temp[i].isdigit():
            s += temp[i]
        else:
            if s.isdigit():
                numbers.append(int(s))
                s = ""
    if s.isdigit():
        numbers.append(int(s))
        s = ""

numbers.sort()

for number in numbers:
    print(number)