#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#define ll long long int
#define SIZE 555555
#define INF -10000000000000
#define MOD 4294967296

using namespace std;

int d[1111][11];
int main()
{
	int n, i, j;
	scanf("%d", &n);
	for (i = 0; i < 10; i++)
		d[0][i] = 1;
	for (i = 1; i <= n; i++)
	{
		d[i][0] = 1;
		for (j = 1; j < 10; j++)
			d[i][j] = (d[i][j - 1] + d[i - 1][j]) % 10007;
	}
	printf("%d", d[n][9]);
}