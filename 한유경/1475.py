# 방 번호(1475)

import sys
input = sys.stdin.readline

N = list(input().strip())
cnt = [0]*10

for n in N:
	cnt[int(n)] += 1

temp = (cnt[6] + cnt[9])//2
if (cnt[6]+cnt[9])%2==1:
	temp += 1

cnt[6] = temp
cnt[9] = temp

print(max(cnt))
