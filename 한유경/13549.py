# 숨바꼭질 3 (13549)

import sys
import heapq
input = sys.stdin.readline

N, K = map(int, input().split())
dist = [sys.maxsize for i in range(200000)]
h = [(0, N)]

while h:
	node = heapq.heappop(h)
	if node[0]>=dist[node[1]]:
		continue
	dist[node[1]] = node[0]
	if node[1]-1>=0:
		if dist[node[1]-1]>node[0]+1:
			heapq.heappush(h, (node[0]+1, node[1]-1))
	if node[1]+1<200000:
		if dist[node[1]+1]>node[0]+1:
			heapq.heappush(h, (node[0]+1, node[1]+1))
	if node[1]*2<200000:
		if dist[node[1]*2]>node[0]:
			heapq.heappush(h, (node[0], node[1]*2))
print(dist[K])
