import sys
from collections import deque

read = sys.stdin.readline
t = int(read())
for _ in range(t):
    p = read().rstrip()
    read()
    array = read()[1:-2]
    if array == '':
        array = []
    else:
        array = array.split(',')
    array = deque(array)
    reverse = False
    try:
        for i in p:
            if i == 'R':
                if reverse == False:
                    reverse = True
                else:
                    reverse = False
            elif i == 'D':
                if reverse == False:
                    array.popleft()
                else:
                    array.pop()
        if reverse == False:
            print('['+','.join(array)+']')
        else:
            print('['+','.join(reversed(array))+']')
    except:
        print('error')