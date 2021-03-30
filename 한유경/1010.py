#다리 놓기

import sys

input = sys.stdin.readline

T = int(input())

cnt = [i for i in range(31)]
for i in range(2, 31):
    cnt[i] *= cnt[i-1]

for t in range(T):
    N, M = map(int, input().split())
    
    if N==M:
        print(1)
    else:
        _min = min(N, M)
        _max = max(N, M)
        print(cnt[_max]//(cnt[_max-_min]*cnt[_min]))