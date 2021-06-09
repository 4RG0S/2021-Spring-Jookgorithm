from collections import deque

def main():
    exp = input()
    que = deque()
    for i in exp:
        if i == '+':
            b, a = que.pop(), que.pop()
            que.append(int(a+b))
        elif i == '-':
            b, a = que.pop(), que.pop()
            que.append(int(a-b))
        elif i == '*':
            b, a = que.pop(), que.pop()
            que.append(int(a*b))
        elif i == '/':
            b, a = que.pop(), que.pop()
            que.append(int(a/b))
        else:
            que.append(int(i))
    print(que.pop())

if __name__ == '__main__':
    main()