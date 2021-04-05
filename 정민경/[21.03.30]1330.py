a, b, c = input().split()
a = int(a)
b = int(b)
c = int(c)

if b < c :
    print(a//(c-b)+1)
else :
    print(-1)
