# 구슬 탈출 (13459)
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
A = [list(input().strip()) for i in range(N)]

R = (0, 0)
B = (0, 0)
for n in range(N):
	for m in range(M):
		if A[n][m]=='R':
			R = [n, m]
		if A[n][m]=='B':
			B = [n, m]
			
queue = deque([[1, R, B]])

def move(t, r, b, n, m):
	success = False
	_r, _b = r.copy(), b.copy()
	# move balls
	# Red ball
	m_r = 0
	while A[_r[0]+n][_r[1]+m]!='#':
		_r[0] += n
		_r[1] += m
		m_r += 1
		if A[_r[0]][_r[1]]=='O':
			success = True
			break
		
	# Blue ball
	m_b = 0
	while A[_b[0]+n][_b[1]+m]!='#':
		_b[0] += n
		_b[1] += m
		m_b += 1
		if A[_b[0]][_b[1]]=='O':
			return False
	
	if _r==_b:
		if m_b<m_r:
			_r[0] -= n
			_r[1] -= m
		else:
			_b[0] -= n
			_b[1] -= m
			
	if _r==r and _b==b:
		return False
	elif _r==R and _b==B:
		return False
	else: 
		queue.append([t+1, _r, _b])
		return success
result = 0
while queue:
	t, r, b = queue.popleft()
	# if move more than 10 times, return False
	if t>10:
		break
		# up
	if move(t, r, b, -1, 0):
		result = 1
		break
	# down
	if move(t, r, b, 1, 0):
		result = 1
		break
	# left
	if move(t, r, b, 0, -1):
		result = 1
		break
	# right
	if move(t, r, b, 0, 1):
		result = 1
		break
print(result)

