import sys

n = int(sys.stdin.readline())

list = []

for i in range(7):
    list.append(float(sys.stdin.readline()))

list.sort()
min = list[6]

for i in range(n-7):
    temp = float(sys.stdin.readline())
    if(min > temp):
        list[6] = temp
        list.sort()
        min = list[6]

for score in list:
    print('%.3f'%score)