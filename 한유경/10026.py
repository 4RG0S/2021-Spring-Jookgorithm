# 적록색약 (10026)
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
M = [list(input()) for i in range(N)]
visited = [[False for x in range(N)] for y in range(N)]
stack = deque()
normal = 0
weak = 0

def dfs():
	global N, M, visited, stack
	if not stack:
		return 0
	(x, y) = stack.pop()
	if visited[y][x]:
		return 0
	visited[y][x] = True
	c = M[y][x]
	
	if y-1>=0 and not visited[y-1][x] and M[y-1][x]==c:
		stack.append((x, y-1))
	if y+1<N and not visited[y+1][x] and M[y+1][x]==c:
		stack.append((x, y+1))
	if x-1>=0 and not visited[y][x-1] and M[y][x-1]==c:
		stack.append((x-1, y))
	if x+1<N and not visited[y][x+1] and M[y][x+1]==c:
		stack.append((x+1, y))
	return 1

for x in range(N):
	for y in range(N):
		stack.append((x, y))
		result = 0
		while stack:
			result += dfs()
		if result!=0:
			normal += 1
			
for x in range(N):
	for y in range(N):
		if M[y][x]=="G":
			M[y][x] = "R"
visited = [[False for x in range(N)] for y in range(N)]

for x in range(N):
	for y in range(N):
		stack.append((x, y))
		result = 0
		while stack:
			result += dfs()
		if result!=0:
			weak += 1

print(normal, weak)
