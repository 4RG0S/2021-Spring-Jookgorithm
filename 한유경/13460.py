# 구슬 탈출 2 (13460)
import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
A = [list(input()) for i in range(N)]
R = deque()
B = deque()
hole = None

for n in range(N):
	for m in range(M):
		if A[n][m]=='R':
			R.append((n, m, 0))
		elif A[n][m]=='B':
			B.append((n, m, "N"))
		elif A[n][m]=='O':
			hole = (n, m)
						
def bfs():
	global R, B
	
	if len(R)==0:
		return -1
	r = R.popleft()
	b = B.popleft()
	
	return max(move("U", r, b), move("D", r, b), move("L", r, b), move("R", r, b))

def move(a, r, b):
	global R, B, A, hole, N, M
	(rn, rm, t), (bn, bm, _a) = r, b
	
	if t>=10:
		return -1
		
	gole = 0
	n = 0
	m = 0
	if a==_a:
		return -1
	if a=="U":
		n -= 1
	elif a=="D":
		n += 1
	elif a=="L":
		m -= 1
	elif a=="R":
		m += 1

	while True:
		if A[rn+n][rm+m]=="#":
			break
		elif A[rn+n][rm+m]=="O":
			gole += 1
			break
		else:
			rn += n
			rm += m
	while True:
		if A[bn+n][bm+m]=="#":
			break
		elif A[bn+n][bm+m]=="O":
			gole += 2
			break
		else:
			bn += n
			bm += m
			
	if gole==1:
		return t+1
	elif gole>=2:
		return -1
	else:
		if rn==bn and rm==bm:
			if n==0:
				if abs(rm-r[1])>abs(bm-b[1]):
					rm -= m
				else:
					bm -= m
			else:
				if abs(rn-r[0])>abs(bn-b[0]):
					rn -= n
				else:
					bn -= n
		if rn==r[0] and rm==r[1] and bn==b[0] and bm==b[1]:
			return 0
		R.append((rn, rm, t+1))
		B.append((bn, bm, a))
		return 0

result = 0
while result==0:		
	result = bfs()
print(result)
