def find(s):
    stack = []
    for i in s:
        if i=='[' or i=='(':
            stack.append(i)
        elif i==']':
            if len(stack) == 0 or stack.pop() != '[':
                return 'NO'
        elif i==')':
            if len(stack) == 0 or stack.pop() != '(':
                return 'NO'
    if len(stack) == 0:
        return 'YES'
    else:
        return 'NO'

n = int(input())
for i in range(n):
    s = input()
    print(find(s))