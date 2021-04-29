def exp(a, b, c):
    if b == 0:
        return 1
    else:
        n = exp(a, b//2, c)%c
        if b%2 == 0:
            return n*n
        else:
            return n*n*a%c


a, b, c = map(int, input().split())
print(exp(a, b, c))