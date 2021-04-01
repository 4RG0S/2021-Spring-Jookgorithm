import heapq
import sys

input = sys.stdin.readline

n = int(input())
study = [list(map(int, input().split())) for _ in range(n)]
study.sort(key=lambda x : x[0])

queue = []  # 현재 수업 중인 리스트
heapq.heappush(queue, study[0][1])  # 시작시간으로 정렬

for i in range(1, n):
    if queue[0] > study[i][0]:  # 다음 수업의 시작시간이 현재 수업의 끝나는 시간보다 빠른 경우
        heapq.heappush(queue, study[i][1])
    else:
        heapq.heappop(queue)    # 수업을 할 수 있으므로 이전 수업 pop
        heapq.heappush(queue, study[i][1])  # 현재 하는 수업 push

print(len(queue))