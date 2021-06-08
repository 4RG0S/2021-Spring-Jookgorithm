#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <string.h>
#define ll long long int
#define SIZE 555555
#define MOD 993244853


using namespace std;

int dp[1<<20],info[21],k,n;

int solve(int bit, int e, int q)
{
	int i;
	//printf("bit=%d q=%d\n", bit, q);
	if (bit == (1 << n) - 1 && q==k)
		return 1;
	if (dp[bit] != 0)
		return dp[bit];
	for (i = 0; i < e; i++)
	{
		if (1 << i & bit)
			continue;
		//printf("info=%d q=%d\n", info[i], q);
		if (info[i] <= q)
		{
			int f = k;
			if (info[i] != q)
				f = q - info[i];
			if (solve(bit | (1 << i), e, f)==1)
				return dp[bit] = 1;
		}
	}
	return dp[bit]=-1;
}

int main()
{
	int t;
	scanf("%d", &t);
	while (t--)
	{
		k = 0;
		memset(info, 0, sizeof(info));
		memset(dp, 0, sizeof(dp));
		int i;
		scanf("%d", &n);
		for (i = 0; i < n; i++)
		{
			scanf("%d", &info[i]);
			k += info[i];
		}
		if (k % 4 != 0)
			printf("no\n");
		else
		{
			k /= 4;
			int res=solve(0,n, k);
			if (res == 1)
				printf("yes\n");
			else
				printf("no\n");
		}
	}

}