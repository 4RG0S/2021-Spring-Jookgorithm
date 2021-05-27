n = int(input())
coordinate = []
for i in range(n):
    coordinate.append(list(map(int, input().split())))
coordinate.sort(key = lambda x : (x[1], x[0]))
for i in coordinate:
    print(i[0],i[1])