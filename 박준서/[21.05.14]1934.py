import math
import sys
read = sys.stdin.readline

t = int(read())
for _ in range(t):
    a, b = map(int, read().split())
    print((a*b)//math.gcd(a, b))