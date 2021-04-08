# N과 M (1) (15649)
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = [False]*N
result = []

def btk(n, l):
	if A[n]:
		return
	A[n] = True
	l += 1
	result.append(str(n+1))
	if l==M:
		print(' '.join(result))
	else:
		for _n in range(N):
			btk(_n, l)
	result.pop()
	A[n] = False
	return

for n in range(N):
	btk(n, 0)
