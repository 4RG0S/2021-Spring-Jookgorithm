n = int(input())
track = {i:1 for i in range(2, n+1)}
dp = [0, 0, 1, 1] + [float('inf')] * (n-3)
for i in range(4, n+1):
    if i%3 == 0:
        dp[i] = min(dp[i//3]+1, dp[i-1]+1, dp[i])
        if dp[i] == dp[i//3]+1:
            track[i] = i//3
        elif dp[i] == dp[i-1]+1:
            track[i] = i-1
    if i%2 == 0:
        dp[i] = min(dp[i//2]+1, dp[i-1]+1, dp[i])
        if dp[i] == dp[i//2]+1:
            track[i] = i//2
        elif dp[i] == dp[i-1]+1:
            track[i] = i-1
    if i%3 != 0 and i%2 != 0:
        dp[i] = min(dp[i-1]+1, dp[i])
        if dp[i] == dp[i-1]+1:
            track[i] = i-1

t = []
while n != 1:
    t.append(n)
    n = track[n]
t.append(1)
print(len(t)-1)
print(' '.join(list(map(str, t))))