import sys
read = sys.stdin.readline
memo = {}
n, m = map(int, read().split())
for _ in range(n):
    site, pw = read().rstrip().split()
    memo[site] = pw

for _ in range(m):
    print(memo[read().rstrip()])