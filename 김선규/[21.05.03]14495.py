def main():
    n = int(input())
    dp = [1,1,1]
    for i in range(3, n):
        dp.append(dp[i-1]+dp[i-3])
    print(dp[n-1])

if __name__ == '__main__':
    main()