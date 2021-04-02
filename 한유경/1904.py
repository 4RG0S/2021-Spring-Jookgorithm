# 01타일 (1904)
import sys
input = sys.stdin.readline

N = int(input())
cnt = [-1]*1000001
cnt[0] = 1
cnt[1] = 1

def dp(n):
	global cnt
	if cnt[n]!=-1:
		return cnt[n]
	cnt[n] = (dp(n-2) + dp(n-1))%15746
	return cnt[n]

for i in range(N):
	dp(i)
print(dp(N))
