A, B = input().split()
A = int(A)
B = int(B)

if A <= B:
    if A == B:
        print("==")

    else:
        print("<")
else:
    print(">")