import sys


def findIsland(px, py):
    q = [(px, py)]
    guidance[px][py] = island
    while q:
        nx, ny = q.pop()
        visited[nx][ny] = 1
        for d in range(4):
            x = nx + dx[d]
            y = ny + dy[d]
            if 0 <= x < n and 0 <= y < n:
                if visited[x][y] == 0 and guidance[x][y] == 1:
                    guidance[x][y] = island
                    q.append((x, y))
                elif guidance[x][y] == 0 and not (nx, ny) in end:
                    end.append((nx, ny))


def distanceByExtension():
    loop = 0
    distance = sys.maxsize
    while end:
        loop += 1
        length = len(end)
        for _ in range(length):
            nx, ny = end.pop(0)
            for d in range(4):
                x = nx + dx[d]
                y = ny + dy[d]
                if 0 <= x < n and 0 <= y < n:
                    if guidance[x][y] == 0:
                        guidance[x][y] = guidance[nx][ny]
                        end.append((x, y))
                    elif guidance[x][y] > guidance[nx][ny]:
                        distance = min(distance, 2 * (loop - 1))
                    elif guidance[x][y] < guidance[nx][ny]:
                        distance = min(distance, 2 * loop - 1)
    return distance

if __name__ == '__main__':
    n = int(sys.stdin.readline())
    guidance = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
    visited = [[0] * n for _ in range(n)]
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    island = 2
    end = list()

    for i in range(n):
        for j in range(n):
            if guidance[i][j] == 1 and visited[i][j] == 0:
                findIsland(i, j)
                island += 1

    print(distanceByExtension())
