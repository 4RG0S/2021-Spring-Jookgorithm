import sys
import heapq

def main():
    n = int(sys.stdin.readline())
    time = [[0,0]]
    parent = {i:[] for i in range(1,n+1)}
    child = {i:[] for i in range(1,n+1)}
    for i in range(1,n+1):
        line = list(map(int, sys.stdin.readline().split()))
        time.append([line[0],i])
        for j in line[2:]:
            parent[i].append(j)
            child[j].append(i)
    
    heap = []
    for i in range(1,n+1):
        if len(parent[i]) == 0:
            heapq.heappush(heap, time[i])
    
    count = 0
    while heap:
        v, i = heapq.heappop(heap)
        count += v
        for j in heap:
            j[0] -= v
        for j in child[i]:
            parent[j].remove(i)
            if len(parent[j]) == 0:
                heapq.heappush(heap, time[j])

    print(count)

if __name__ == '__main__':
    main()