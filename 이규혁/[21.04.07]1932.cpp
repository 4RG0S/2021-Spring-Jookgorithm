#include <stdio.h>
#include <algorithm>
using namespace std;

int main()
{
	int n, i, j, d[555][555] = { 0 }, res = 0;

	scanf("%d", &n);

	for (i = 1; i <= n; i++)
	{
		for (j = 1; j <= i; j++)
		{
			int input;
			scanf("%d", &input);

			d[i][j] = max(d[i - 1][j - 1], d[i - 1][j]) + input;
			res = max(res, d[i][j]);
		}
	}
	printf("%d", res);

}