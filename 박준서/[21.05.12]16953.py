from collections import deque

class Node:
    def __init__(self, value, end):
        self.value = value
        if value < end:
            self.left = Node(value*2, end)
            self.right = Node(value*10+1, end)

def search(start, end):
    queue = deque([start])
    visit = []
    count = 1

    while queue:
        for _ in range(len(queue)):
            node = queue.popleft()
            if node.value in visit:
                continue
            if node.value == end:
                return count
            visit.append(node.value)
            if node.value <= end//2:
                queue.append(node.left)
                queue.append(node.right)
        count += 1
    return -1


a, b = map(int, input().split())
start = Node(a, b)
print(search(start, b))