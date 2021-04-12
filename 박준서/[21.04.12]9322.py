import sys
read = sys.stdin.readline
t = int(read())
for _ in range(t):
    crypto = {}
    crypto2 = {}
    n = int(read())
    ans = [0 for i in range(n)]
    public_key1 = read().rstrip().split()
    public_key2 = read().rstrip().split()
    for i in range(n):
        crypto[public_key1[i]] = i
        crypto2[i] = public_key2[i]
    sentence = read().rstrip().split()
    for i in range(n):
        ans[crypto[crypto2[i]]] = sentence[i]
    print(' '.join(ans))