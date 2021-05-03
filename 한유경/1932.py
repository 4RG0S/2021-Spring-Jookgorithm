# 정수 삼각형 (1932)
import sys
input = sys.stdin.readline

N = int(input())
T = [list(map(int, input().split())) for i in range(N)]
cnt = [[-1 for i in range(n)] for n in range(1, N+1)]
def dp(n, i):
	if n==N:
		return 0
	if cnt[n][i]!=-1:
		return cnt[n][i]
	cnt[n][i] = T[n][i] + max(dp(n+1, i), dp(n+1, i+1))
	return cnt[n][i]

print(dp(0, 0))
