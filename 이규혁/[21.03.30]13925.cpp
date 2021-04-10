#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <algorithm>
#include <vector>
#include <queue>
#include <algorithm>
#include <memory.h>
#define ll long long int
#define MOD 1000000007

using namespace std;

struct seg {
	ll sum, mul;
};

ll seq[111111];
seg lazy[888888];
ll tree[888888];

ll init(int node, int l, int r, int idx, ll val)
{
	int mid = (l + r) / 2;

	if (idx<l || idx>r)
		return tree[node];
	if (l == r)
	{
		tree[node] = val;
		return tree[node];
	}
	tree[node] = (init(node * 2, l, mid, idx, val) + init(node * 2 + 1, mid + 1, r, idx, val)) % MOD;
	//printf("%d %d %lld\n", l, r, tree[node].res);
	return tree[node];
}
void pgt(int node, ll s, ll m, ll f)
{
	lazy[node].sum = ((lazy[node].sum * m) % MOD + s) % MOD;
	lazy[node].mul = (lazy[node].mul * m) % MOD;
}

void update(int node, int l, int r, int ql, int qr, ll s, ll m)
{
	int mid = (l + r) / 2;
	if (lazy[node].sum || lazy[node].mul != 1)
	{
		ll f = 1, sum, mul;
		if (l != r)
		{
			pgt(node * 2, lazy[node].sum, lazy[node].mul, f);
			pgt(node * 2 + 1, lazy[node].sum, lazy[node].mul, f);
		}
		sum = lazy[node].sum;
		mul = lazy[node].mul;
		tree[node] = ((tree[node] * mul) % MOD + (sum * (r - l + 1)) % MOD) % MOD;
		lazy[node].sum = 0;
		lazy[node].mul = 1;
	}
	if (ql > r || qr < l)
		return;
	if (ql <= l && qr >= r)
	{
		//printf("bef res=%lld\n", tree[node]);
		tree[node] = ((tree[node] * m) % MOD + (s * (r - l + 1)) % MOD) % MOD;
		//printf("%d %d res=%lld\n", l, r, tree[node]);

		ll f = 1;
		if (m == 0)
			f = 0;
		if (l != r)
		{
			pgt(node * 2, s, m, f);
			pgt(node * 2 + 1, s, m, f);
		}
		return;
	}
	update(node * 2, l, mid, ql, qr, s, m);
	update(node * 2 + 1, mid + 1, r, ql, qr, s, m);
	tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % MOD;
	//printf("%d %d res=%lld\n", l, r, tree[node]);
}

ll query(int node, int l, int r, int ql, int qr)
{
	int mid = (l + r) / 2;
	ll left, right;
	if (lazy[node].sum || lazy[node].mul != 1)
	{
		ll f = 1, sum, mul;
		if (l != r)
		{
			pgt(node * 2, lazy[node].sum, lazy[node].mul, f);
			pgt(node * 2 + 1, lazy[node].sum, lazy[node].mul, f);
		}

		sum = lazy[node].sum;
		mul = lazy[node].mul;
		tree[node] = ((tree[node] * mul) % MOD + (sum * (r - l + 1)) % MOD) % MOD;
		lazy[node].sum = 0;
		lazy[node].mul = 1;
	}
	if (ql > r || qr < l)
		return 0;
	if (ql <= l && qr >= r)
		return tree[node];
	left = query(node * 2, l, mid, ql, qr);
	right = query(node * 2 + 1, mid + 1, r, ql, qr);
	//printf("%d %d left = %lld right = %lld\n", l, r, left, right);
	return (left + right) % MOD;
}

int main()
{
	int n, i, m;

	scanf("%d", &n);
	for (i = 0; i < 888888; i++)
		lazy[i].mul = 1;
	for (i = 1; i <= n; i++)
	{
		seq[i] = 1000000000;
		scanf("%lld", &seq[i]);
		init(1, 1, n, i, seq[i]);
	}
	scanf("%d", &m);

	while (m--)
	{
		int cmd, x, y;
		ll v;

		scanf("%d", &cmd);
		//printf("%lld\n", tree[1].mul);
		if (cmd == 1)
		{
			scanf("%d%d%lld", &x, &y, &v);
			update(1, 1, n, x, y, v, 1);
		}
		else if (cmd == 2)
		{
			scanf("%d%d%lld", &x, &y, &v);
			update(1, 1, n, x, y, 0, v);
		}
		else if (cmd == 3)
		{
			scanf("%d%d%lld", &x, &y, &v);
			update(1, 1, n, x, y, v, 0);
		}
		else
		{
			scanf("%d%d", &x, &y);
			printf("%lld\n", query(1, 1, n, x, y));
		}
	}
}
/*
5
1 1 1 1 1
100000
3 1 5 3
1 3 5 2
2 3 5 2
4 4 5
4 3 5
4 1 5
2 1 5 1000000000
4 1 5
3 1 5 1
2 1 5 100000
4 1 5
2 1 5 1000
4 1 5
2 1 5 2
4 1 5
1 3 3 7
4 1 5
*/

/*
5
1 1 1 1 1
10000
3 1 5 5
3 1 5 3
3 1 5 6
4 1 5
4 3 3
4 2 4
4 5 5
1 2 3 1
4 1 5
2 2 3 6
4 1 5


1 1 1 1 1
1 4 4 4 4
1 4 4 12 12
2 2 2 2 12
2 6 2 2 12
1 1 1 1 1
5 5 5 1 1
7 7 7 1 1
7 9 9 1 1
7 9 45 5 1


3 5
4 3
3

23 15
68

13
*/


