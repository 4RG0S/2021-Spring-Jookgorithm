import sys
read = sys.stdin.readline

def search(graph, start):
    stack = [start]
    visited = []
    while stack:
        cur = stack.pop()
        if cur in visited:
            continue
        visited.append(cur)
        stack.extend(graph[cur])

    return len(visited)-1

n = int(read())
m = int(read())
graph = {i:[] for i in range(1, n+1)}
for i in range(m):
    a, b = map(int, read().split())
    graph.get(a, list()).append(b)
    graph.get(b, list()).append(a)
print(search(graph, 1))