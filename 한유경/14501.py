# 퇴사 (14501)
import sys
input = sys.stdin.readline

N = int(input())
A = []
cnt = [-1 for i in range(N)]

for n in range(N):
	T, P = map(int, input().split())
	A.append((T, P))
		
def dp(n):
	if n==N:
		return 0
	if cnt[n]!=-1:
		return cnt[n]
	result = dp(n+1)
	_n = n+A[n][0]
	if _n>N:
		cnt[n] = result
		return result
	result = max(result, dp(_n)+A[n][1])
	cnt[n] = result
	return result

print(dp(0))
