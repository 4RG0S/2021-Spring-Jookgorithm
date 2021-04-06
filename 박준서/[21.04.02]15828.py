from collections import deque
n = int(input())
buf =  deque()
packet = input()
while packet != '-1':
    if packet == '0':
        buf.popleft()
    elif len(buf) < n:
        buf.append(packet)
    packet = input()

print(' '.join(buf) if len(buf) > 0 else 'empty')