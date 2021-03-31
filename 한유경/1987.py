# 알파벳(1987)
import sys
from collections import deque
input = sys.stdin.readline

# get input
R, C = map(int, input().split())
A = [['-' for i in range(C+2)]]
for c in range(R):
	temp = list('-'+input().strip()+'-')
	A.append(temp)
A.append(['-' for i in range(C+2)])

# use stack
string = ''
result = 0
stack = deque([(1, 1, 0)])
while len(stack)>0:
		r, c, l = stack.pop()
		if len(string)>l:
			result = max(result, len(string))
			string = string[:l]
		if A[r][c] in string:
			continue
		string += A[r][c]
		l += 1
		if A[r-1][c]!='-':
			stack.append((r-1, c, l))
		if A[r+1][c]!='-':
			stack.append((r+1, c, l))
		if A[r][c-1]!='-':
			stack.append((r, c-1, l))
		if A[r][c+1]!='-':
			stack.append((r, c+1, l))
result = max(result, len(string))
print(result)
