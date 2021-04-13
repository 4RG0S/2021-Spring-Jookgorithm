import sys, heapq

def main():
    n = int(sys.stdin.readline())
    que = []
    for _ in range(n):
        i = int(sys.stdin.readline())
        if i == 0:
            if len(que) == 0:
                print(0)
            else:
                print(-heapq.heappop(que))
        else:
            heapq.heappush(que, -i)

if __name__ == '__main__':
    main()