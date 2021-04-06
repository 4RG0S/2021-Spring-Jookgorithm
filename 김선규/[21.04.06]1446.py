import sys, heapq

def main():
    n, l = map(int, sys.stdin.readline().split())
    load = {i:[(1,i+1)] for i in range(l)}
    load[l] = []
    for _ in range(n):
        s, d, v = map(int, sys.stdin.readline().split())
        if d <= l:
            load[s].append((v,d))
    
    dist = [i for i in range(l+1)]
    que = []
    heapq.heappush(que, [0, 0])
    
    while que:
        v = heapq.heappop(que)
        for i in load[v[1]]:
            if dist[i[1]] >= v[0] + i[0]:
                dist[i[1]] = v[0] + i[0]
                heapq.heappush(que, [dist[i[1]],i[1]])

    m = l
    for i in range(l, 0, -1):
        m = min(m, dist[i] + l-i)
    print(m)

if __name__ == '__main__':
    main()