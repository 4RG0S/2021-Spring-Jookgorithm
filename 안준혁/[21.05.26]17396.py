import heapq
import sys

input = sys.stdin.readline
INF = sys.maxsize


def dijkstra():
    q = []
    start = 0
    heapq.heappush(q, (0, start))
    times[start] = 0
    while q:
        time, now = heapq.heappop(q)
        if times[now] < time:
            continue
        for next, nextTime in ways[now]:
            comp = time + nextTime
            if comp < times[next] and canI[next] == 0:
                times[next] = comp
                print(comp, next)
                heapq.heappush(q, (comp, next))


n, m = map(int, input().split())

canI = list(map(int, input().split()))
canI[-1] = 0

times = [INF] * n
ways = [[] for _ in range(n)]
for _ in range(m):
    a, b, t = map(int, input().split())
    if canI[a] == 0 and canI[b] == 0:
        ways[b].append([a, t])
        ways[a].append([b, t])
dijkstra()

if times[n - 1] == INF:
    print("-1")
else:
    print(times[n-1])

