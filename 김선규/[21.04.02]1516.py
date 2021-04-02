import sys, heapq

def main():
    n = int(sys.stdin.readline())
    time = [[0,0,0]]
    parent = {i:[] for i in range(1,n+1)}
    child = {i:[] for i in range(1,n+1)}
    for i in range(1,n+1):
        line = list(map(int, sys.stdin.readline().split()))
        time.append([line[0],i,0])
        for j in line[1:-1]:
            parent[i].append(j)
            child[j].append(i)

    heap = []
    for i in range(1,n+1):
        if len(parent[i]) == 0:
            heapq.heappush(heap, time[i])
            time[i][2] = time[i][0]

    while heap:
        v, i, t = heapq.heappop(heap)
        for j in child[i]:
            parent[j].remove(i)
            time[j][2] = max(time[j][2], time[j][0] + t)
            if len(parent[j]) == 0:
                heapq.heappush(heap, time[j])

    for i in range(1,n+1):
        print(time[i][2])

if __name__ == '__main__':
    main()