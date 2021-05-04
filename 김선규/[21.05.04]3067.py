def main():
    for _ in range(int(input())):
        n = int(input())
        coins = list(map(int, input().split()))
        m = int(input())
        dp = [[0 for i in range(m+1)] for i in range(n+1)]
        for i in range(1, n+1):
            for j in range(1, m+1):
                if coins[i-1] == j:
                    dp[i][j] = dp[i-1][j] + 1
                elif coins[i-1] < j:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
                elif coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
        print(dp[i][j])

if __name__ == '__main__':
    main()