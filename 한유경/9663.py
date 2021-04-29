# N-Queen (9663)

N = int(input())
R = [-1]*15
visited = [False]*15
result = 0

def dfs(r):
	global N, R, visited, result
	
	if r==N:
		result += 1
	
	for c in range(N):
		if visited[c]:
			continue
		do = True
		for _r in range(r):
			if abs(r-_r)==abs(c-R[_r]):
				do = False
				break
		if do:
			R[r] = c
			visited[c] = True
			dfs(r+1)
			visited[c] = False

dfs(0)
print(result)
