#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <algorithm>
#include <vector>
#include <queue>
#include <algorithm>
#include <memory.h>
#define ll long long int
#define MOD 5000000

using namespace std;

int main()
{
	int t, d[12], i;
	scanf("%d", &t);
	d[1] = 1;
	d[2] = 2;
	d[3] = 4;
	for (i = 4; i <= 11; i++)
	{
		d[i] = d[i - 1] + d[i - 2] + d[i - 3];
		//printf("%d\n", d[i]);
	}
	while (t--)
	{
		int n;
		scanf("%d", &n);
		printf("%d\n", d[n]);
	}
}