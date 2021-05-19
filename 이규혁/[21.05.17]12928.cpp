#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int dp[55][55][2][1111];

int main()
{
	int n, s, i, j, k;
	scanf("%d%d", &n, &s);
	dp[3][2][0][1] = dp[3][1][0][1] = dp[3][1][1][1] = dp[3][0][1][1] = 1;

	for (i = 1; i < n; i++)
	{
		for (j = 0; j <= i; j++)
		{
			for (k = 1; k <= s; k++)
			{
				//printf("dp[%d][%d][0][%d]=%d dp[%d][%d][1][%d]=%d\n", i, j, k, dp[i][j][0][k],i,j,k,dp[i][j][1][k]);
				if (dp[i][j][1][k] && k + j + 1 <= s)
				{
					dp[i + 1][j + 1][1][k + j + 1] = 1;
					dp[i + 1][0][1][k + j + 1] = 1;
				}
				if (dp[i][j][0][k] && k + j <= s)
				{
					dp[i + 1][j + 1][0][k + j] = 1;
					dp[i + 1][0][1][k + j] = 1;
					dp[i + 1][1][0][k + j] = 1;
				}
			}
		}
	}
	for (i = 1; i <= n; i++)
	{
		if (dp[n][i][0][s] || dp[n][i][1][s])
		{
			printf("1");
			break;
		}
	}
	if (i > n)
		printf("0");

}