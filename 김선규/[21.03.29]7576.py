import sys
from collections import deque

def main():
    m, n = map(int, sys.stdin.readline().split())
    li = [sys.stdin.readline().split() for _ in range(n)]

    q1 = deque()
    q2 = deque()
    c = 0

    for i in range(n):
        for j in range(m):
            if li[i][j] == '1':
                q1.append((i, j))

    while True:
        while q1:
            v = q1.popleft()
            for i in [(1,0),(0,1),(-1,0),(0,-1)]:
                a = v[0]+i[0]
                b = v[1]+i[1]
                if (0 <= a < n) & (0 <= b < m):
                    if li[a][b] == '0':
                        li[a][b] = '1'
                        q2.append((a,b))
                        
        if len(q2) == 0:
            break
        q1 = q2
        q2 = deque()
        c += 1

    for i in li:
        for j in i:
            if j == '0':
                c = -1
    
    print(c)


if __name__ == '__main__':
    main()