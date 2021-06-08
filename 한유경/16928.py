# 뱀과 사다리 게임 (16928)
import sys
from collections import deque
input = sys.stdin.readline

(N, M) = map(int, input().split())
borad = [i for i in range(100)]

for i in range(N+M):
	(start, end) = map(int, input().split())
	borad[start-1] = end-1
	
queue = deque([(0, 0)])
visited = [False for i in range(100)]
visited[0] = True

def bfs():
	global queue, visited, borad
	n, t = queue.popleft()
	if n==99:
		return t
	while borad[n]!=n:
		n = borad[n]
		if not visited[n]:
			visited[n] = True
	for i in range(1, 7):
		if n+i>99:
			break
		if not visited[n+i]:
			queue.append((n+i, t+1))
			visited[n+i] = True
	return -1

result = -1
while result==-1:
	result = bfs()
print(result)
