import sys

count = int(sys.stdin.readline())

for _ in range(count):
    a, b = sys.stdin.readline().split()
    distance = int(b) - int(a)
    if distance == 1:
        print(1)
    elif distance == 2:
        print(2)
    elif distance > 2:
        distance -= 2
        i = 3
        j = 2
        tf = False
        while True:
            if not tf:
                tf = not tf
                distance -= j
            else:
                tf = not tf
                distance -= j
                j += 1
            if distance <= 0:
                break
            else:
                i += 1
        print(i)
