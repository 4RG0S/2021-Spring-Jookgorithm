# 셀프 넘버
import sys
input = sys.stdin.readline

cnt = [True for i in range(10001)]

for i in range(1, 10001):
    temp = i + sum(map(int, list(str(i))))
    if temp>10000:
        continue
    cnt[temp] = False

for i in range(1, 10001):
    if cnt[i]:
        print(i)