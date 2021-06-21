import sys
read = sys.stdin.readline
n, m = map(int, read().split())
newarr = [0 for _ in range(n+m)]
arr1 = list(map(int, read().split()))
arr2 = list(map(int, read().split()))
point1, point2 = 0, 0
for i in range(n+m):
    if point1 > n-1:
        newarr[i] = arr2[point2]
        point2 += 1
    elif point2 > m-1:
        newarr[i] = arr1[point1]
        point1 += 1
    elif arr1[point1] < arr2[point2]:
        newarr[i] = arr1[point1]
        point1 += 1
    else:
        newarr[i] = arr2[point2]
        point2 += 1
print(' '.join(list(map(str, newarr))))