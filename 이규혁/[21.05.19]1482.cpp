#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <algorithm>
#include <memory.h>
#include <vector>
#include <string.h>
#define ll long long int
#define SIZE 111111
#define MOD 5000000

using namespace std;

ll maxl(ll a, ll b)
{
	if (a > b)
		return a;
	return b;
}
ll minl(ll a, ll b)
{
	if (a < b)
		return a;
	return b;
}

void main()
{
	ll n, info[21] = { 0 }, t, k = 1, info2[21][10] = { 0 }, info3[21][10] = { 0 },res[21][21] = { 0 }, mn = 9223372036854775807;
	int i=1,c, j,l;

	scanf("%lld", &n);
	t = n;
	while (t != 0)
	{
		info2[i][t % 10]++;
		info[i] = t % 10;
		t /= 10;
		k *= 10;
		for (j = 0; j < 10; j++)
		{
			info2[i][j] += info2[i - 1][j];
			info3[i][j] = info2[i][j];
		}
		i++;
	}
	c = i-1;
	t = 0;
	for (i = 0; i < 10; i++)
	{
		//printf("i=%d info=%lld t=%lld\n", i, info2[c][i],t);
		if (t != 0 && info2[c][i] != t && info2[c][i]!=0)
			break;
		if (t == 0 && info2[c][i] != 0)
			t = info2[c][i];
	}
	if (i >= 10)
	{
		printf("%lld", n);
		return;
	}
	for (l = 1; l <= c; l++)
	{
		//printf("L=%d\n", l);
		for (i = 1; i <= c; i++)
		{
			for (j = 0; j < 10; j++)
				info2[i][j] = info3[i][j];
		}
		for (i = 1; i <= c; i++)
		{
			/*if(l==2)*/
			//if(l==1) printf("i=%d\n", i);
			info2[c][info[i]]--;
			for (j = info[i] + 1; j < 10; j++)
			{
				//if (l == 2)
				//if(l==1) printf("j=%d\n", j);
				info2[c][j]++;
				ll mx = 0, x[10] = { 0 }, cnt = 0, x2[10] = { 0 };
				for (k = 0; k < 10; k++)
				{
					//if (l == 2)
					//if(l==1) printf("info2[c][%lld]=%lld\n",  k, info2[c][k]);
					mx = maxl(mx, info2[c][k]);
				}
				for (k = 0; k < 10; k++)
				{
					if (info2[c][k] != 0)
					{
						x[k] = l - info2[c][k];
						x2[k] += x[k];
						cnt += x[k];
					}
				}
				//if (l == 1) printf("cnt=%lld\n", cnt);
				if (cnt > i - 1 || mx>l)
				{
					info2[c][j]--;
					continue;
				}
				for (k = 0; k < 10; k++)
				{
					if (info2[c][k] == 0)
					{
						if (cnt + l <= i - 1)
						{
							x2[k] += l;
							cnt += l;
						}
					}
					//if (l == 1) printf("x2[%lld]=%lld cnt=%lld\n",k, x2[k],cnt);
				}
				if (cnt < i - 1)
				{
					info2[c][j]--;
					continue;
				}
				ll p = 1;
				int m;
				for (k = 1; k <= i - 1; k++)
				{
					for (m = 9; m >= 0; m--)
					{
					//	if (l == 1) printf("x2[%d]=%lld\n", m, x2[m]);
						if (x2[m] != 0)
						{
							res[l][k] = m;
							x2[m]--;
							break;
						}
					}
					//if (l == 1) printf("res[19][%lld]=%lld\n", k, res[19][k]);
				}

				info2[c][j]--;
				res[l][k++] = j;
				for (; k <= c; k++)
					res[l][k] = info[k];
				break;
			}
			//info2[c][info[i]]++;
			if (j < 10)
				break;
		}
		if (i > c && c<19)
		{
			ll flag[10] = { 0 };
			if (c % l != 0)
				continue;
			res[l][c + 1] = 1;
			flag[1] = 1;
			for (i = c; i >= 1; i--)
			{
				for (j = 0; j < 10; j++)
				{
					if (flag[j] <= l)
					{
						res[l][i] = j;
						flag[j]++;
						break;
					}
				}
			}
		}
	}
	ll res2[20] = { 0 };
	for (i = 1; i <= c; i++)
	{
		ll mul = 1;
		for (j = 1; j < 20; j++)
		{
			//if (i == 1) printf("res[19][%d]=%lld\n", j, res[19][j]);
			res2[i] += res[i][j] * mul;
			mul *= 10;
		}
		//printf("res2[%d]=%lld\n", i, res2[i]);
		if (res2[i] != 0)
		{
			mn = minl(mn, res2[i]);
		}
	}
	printf("%lld", mn);
}

//154231512
//41354321
//41355
//1000000000111111111
//1000000000000000000
//12233445566778899