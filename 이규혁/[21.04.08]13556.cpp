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


int info[111111], d[111111], seg[444444], t[111111];

void update(int node, int l, int r, int idx, int val)
{
	int mid = (l + r) / 2;

	if (l > idx || r < idx)
		return;;
	seg[node] = (seg[node] + val) % MOD;
	if (l == r)
		return;
	update(node * 2, l, mid, idx, val);
	update(node * 2 + 1, mid + 1, r, idx, val);
}

int query(int node, int l, int r, int ql, int qr)
{
	int mid = (l + r) / 2;

	if (ql > r || qr < l)
		return 0;
	if (ql <= l && qr >= r)
		return seg[node];
	return (query(node * 2, l, mid, ql, qr) + query(node * 2 + 1, mid + 1, r, ql, qr)) % MOD;
}

int main()
{
	int n, k, i, j, res;

	scanf("%d%d", &n, &k);

	for (i = 1; i <= n; i++)
	{
		scanf("%d", &info[i]);
	}
	for (i = 1; i <= k; i++)
	{
		res = 0;
		int f = 0;
		if (i == 1)
			f = 1;
		memset(t, 0, sizeof(t));
		memset(seg, 0, sizeof(seg));
		for (j = 1; j <= n; j++)
		{
			int tmp = d[j];
			int r = query(1, 1, 100000, 1, info[j] - 1);
			update(1, 1, 100000, info[j], tmp);
			if (r < t[info[j]])
				r += MOD;
			d[j] = r + f - t[info[j]];
			t[info[j]] += d[j];
			res = (res + d[j]) % MOD;
		}

	}
	printf("%d", res);

}