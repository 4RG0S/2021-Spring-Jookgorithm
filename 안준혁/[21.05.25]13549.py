import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)


def dijkstra():
    q = []
    start = n

    heapq.heappush(q, (0, start))
    change[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        x = now + 1
        if 0 <= x <= 100000:
            temp = dist + 1
            if change[x] > temp:
                change[x] = temp
                heapq.heappush(q, (temp, x))
        x = now - 1
        if 0 <= x <= 100000:
            temp = dist + 1
            if change[x] > temp:
                change[x] = temp
                heapq.heappush(q, (temp, x))
        x = now * 2
        if 0 <= x <= 100000:
            temp = dist
            if change[x] > temp:
                change[x] = temp
                heapq.heappush(q, (temp, x))


n, k = map(int, input().split())

change = [INF] * 100001

dijkstra()
print(change[k])
