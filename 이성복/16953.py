a, b = map(int, input().split())

queue = [(a, 1)]
while queue:
    tmp, cnt = queue.pop(0)
    first, second = tmp * 2, (tmp * 10) + 1
    if first == b:
        print(cnt + 1)
        exit(0)
    if second == b:
        print(cnt + 1)
        exit(0)

    if first != b and first < b:
        queue.append((first, cnt + 1))
    if second != b and second < b:
        queue.append((second, cnt + 1))

print(-1)