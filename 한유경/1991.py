# 트리 순회 (1991)
import sys
from collections import deque
input = sys.stdin.readline

node = [None]*26
stack = deque()

N = int(input())
for i in range(N):
	name, left, right = input().strip().split()
	node[ord(name)-65] = [name, left, right]

stack = deque([0])
preorder = ''
inorder = ''
postorder = ''

def dfs():
	global preorder, inorder, postorder, stack
	index = stack.pop()
	preorder += node[index][0]
	if node[index][1]!=".":
		stack.append(ord(node[index][1])-65)
		dfs()
	inorder += node[index][0]
	if node[index][2]!=".":
		stack.append(ord(node[index][2])-65)
		dfs()
	postorder += node[index][0]

dfs()
print(preorder)
print(inorder)
print(postorder)
		
