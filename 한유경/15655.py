# N과 M (6)
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = list(map(int, input().split()))
A.sort()
S = ['']*M
last = -1

def btk(l):
	global last
	if l==M:
		print(' '.join(S))
		return
	for i in range(last+1, N):
		last = i
		S[l] = str(A[i])
		btk(l+1)
	return

btk(0)
