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

int info[111111],seg[444444],info3[111111],info2[111111];

int query(int node, int l, int r, int ql, int qr)
{
	int mid = (l + r) / 2;
	if (l > qr || r < ql)
		return 0;
	if (l >= ql && r <= qr)
		return seg[node];
	return (query(node * 2, l, mid, ql, qr) + query(node * 2 + 1, mid + 1, r, ql, qr)) % MOD;

}
int update(int node, int l, int r, int idx, int v)
{
	int mid = (l + r) / 2;
	if (l > idx || r < idx)
		return seg[node];
	if (l == r)
		return seg[node] = (seg[node] + v) % MOD;
	return seg[node]=(update(node * 2, l, mid, idx, v) + update(node * 2 + 1, mid + 1, r, idx, v)) % MOD;
}

int main()
{
	int n, k,i,j,res=0;
	scanf("%d%d", &n, &k);

	for (i = 1; i <= n; i++)
		scanf("%d", &info[i]);
	for (i = 1; i <= k; i++)
	{
		for (j = 1; j <= n; j++)
		{

			info2[j] = query(1, 1, 100000, 1, info[j] - 1);
			update(1, 1, 100000, info[j], info3[j]);
			if (i == 1)
				info2[j] = 1;
			if (i == k)
				res = (res + info2[j]) % MOD;
			
		}
		memset(seg, 0, sizeof(seg));
		for (j = 1; j <= n; j++)
		{
			info3[j] = info2[j];
			info2[j] = 0;
		}
	}
	printf("%d", res);
}
