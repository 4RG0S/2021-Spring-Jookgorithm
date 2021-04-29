# N과 M (5) (15654)
import sys
input = sys.stdin.readline
print = sys.stdout.write

N, M = map(int, input().split())
A = list(map(int, input().split()))
A.sort()
cnt = [True]*N
S = ['']*M
def btk(l):

	if l==M:
		print(" ".join(S)+'\n')
		return
	for i in range(N):
		if cnt[i]:
			S[l] = str(A[i])
			cnt[i] = False
			btk(l+1)
			cnt[i] = True
	return

btk(0)
