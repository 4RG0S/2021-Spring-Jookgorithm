import sys
from collections import deque

def main():
    m, n, h = map(int, sys.stdin.readline().split())
    li = [[sys.stdin.readline().split() for j in range(n)] for i in range(h)]

    q1 = deque()
    q2 = deque()
    count = 0

    for i in range(h):
        for j in range(n):
            for k in range(m):
                if li[i][j][k] == '1':
                    q1.append((i, j, k))
    
    while True:
        while q1:
            v = q1.popleft()
            for i in [(1,0,0),(0,1,0),(0,0,1),(-1,0,0),(0,-1,0),(0,0,-1)]:
                a = v[0]+i[0]
                b = v[1]+i[1]
                c = v[2]+i[2]
                if (0 <= a < h) & (0 <= b < n) & (0 <= c < m):
                    if li[a][b][c] == '0':
                        li[a][b][c] = '1'
                        q2.append((a,b,c))

        if len(q2) == 0:
            break
        q1 = q2
        q2 = deque()
        count += 1

    for i in li:
        for j in i:
            for k in j:
                if k == '0':
                    count = -1
    
    print(count)


if __name__ == '__main__':
    main()