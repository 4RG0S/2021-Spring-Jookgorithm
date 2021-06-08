#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#define ll long long int
#define SIZE 555555
#define K 9223372036854775807


using namespace std;

struct seg {
	ll sum, mul;
};
ll MOD = 4294967296;
vector<int> inp[SIZE], g[SIZE];
int top[SIZE], dep[SIZE], par[SIZE], sz[SIZE], in[SIZE], out[SIZE], idx;

seg lazy[SIZE * 10];
ll tree[SIZE * 10];


int dfs1(int now)
{
	int i;
	sz[now] = 1;
	for (i = 0; i < inp[now].size(); i++)
	{
		int next = inp[now][i], nextsz;
		if (next == par[now])
			continue;
		par[next] = now;
		dep[next] = dep[now] + 1;
		nextsz = dfs1(next);
		sz[now] += nextsz;
		g[now].push_back(next);
		if (nextsz > sz[g[now][0]])
			swap(g[now][0], g[now][g[now].size() - 1]);
	}
	return sz[now];
}

void dfs2(int now)
{
	int i;
	in[now] = ++idx;

	for (i = 0; i < g[now].size(); i++)
	{
		int next = g[now][i];
		top[next] = next;
		if (i == 0)
			top[next] = top[now];
		dfs2(next);
	}
	out[now] = idx;
}

void pgt(int node, ll s, ll m)
{
	int c;
	ll t;
	if (lazy[node].sum * m<0)
		t = (lazy[node].sum * m + K + 1) % MOD;
	else
		t = lazy[node].sum * m % MOD;
	lazy[node].sum = (t + s) % MOD;
	if (lazy[node].mul * m < 0)
		t = (lazy[node].mul * m + K + 1) % MOD;
	else
		t = lazy[node].mul * m % MOD;
	lazy[node].mul = t;
}

void update(int node, int l, int r, int ql, int qr, ll s, ll m)
{
	int mid = (l + r) / 2;
	if (lazy[node].sum || lazy[node].mul != 1)
	{
		ll sum, mul;
		if (l != r)
		{
			pgt(node * 2, lazy[node].sum, lazy[node].mul);
			pgt(node * 2 + 1, lazy[node].sum, lazy[node].mul);
		}
		sum = lazy[node].sum;
		mul = lazy[node].mul;
		int c;
		ll t;
		if (tree[node] * mul < 0)
		{
			t = (tree[node] * mul + K + 1) % MOD;
		}
		else
			t = tree[node] * mul % MOD;
		tree[node] = (t + (sum * (r - l + 1)) % MOD) % MOD;
		lazy[node].sum = 0;
		lazy[node].mul = 1;
	}
	if (ql > r || qr < l)
		return;
	if (ql <= l && qr >= r)
	{
		//printf("bef res=%lld\n", tree[node]);
		int c;
		ll t;
		if (tree[node] * m < 0)
		{
			t = (tree[node] * m + K + 1) % MOD;
		}
		else
			t = tree[node] * m % MOD;
		tree[node] = (t + (s * (r - l + 1)) % MOD) % MOD;
		//printf("%d %d res=%lld\n", l, r, tree[node]);

		if (l != r)
		{
			pgt(node * 2, s, m);
			pgt(node * 2 + 1, s, m);
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
		ll sum, mul;
		if (l != r)
		{
			pgt(node * 2, lazy[node].sum, lazy[node].mul);
			pgt(node * 2 + 1, lazy[node].sum, lazy[node].mul);
		}

		sum = lazy[node].sum;
		mul = lazy[node].mul;
		int c;
		ll t;
		if (tree[node] * mul < 0)
		{
			t = (tree[node] * mul + K + 1) % MOD;
		}
		else
			t = tree[node] * mul % MOD;
		tree[node] = (t + (sum * (r - l + 1)) % MOD) % MOD;
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
	int n, q, i, j;
	scanf("%d%d", &n, &q);
	for (i = 0; i < n - 1; i++)
	{
		int a, b;
		a = i + 1;
		b = a + 1;
		scanf("%d%d", &a, &b);
		inp[a].push_back(b);
		inp[b].push_back(a);
	}
	top[1] = dep[1] = 1;
	dfs1(1);
	dfs2(1);
	for (i = 0; i < SIZE * 10; i++)
		lazy[i].mul = 1;
	while (q--)
	{
		int comm, x, y;
		ll v, r = 0;

		scanf("%d", &comm);
		if (comm == 2 || comm == 4 || comm == 6)
		{
			scanf("%d%d", &x, &y);
			if (comm != 6)
				scanf("%lld", &v);
			ll m, s;
			if (comm == 2)
			{
				s = v;
				m = 1;
			}
			else if (comm == 4)
			{
				s = 0;
				m = v;
			}
			while (top[x] != top[y])
			{
				if (dep[top[x]] < dep[top[y]])
					swap(x, y);
				//printf("x = %d in[top[x]] = %d in[x] = %d\n", x, in[top[x]], in[x]);
				if (comm == 6)
					r = (r + query(1, 1, n, in[top[x]], in[x])) % MOD;
				else
					update(1, 1, n, in[top[x]], in[x], s, m);
				x = par[top[x]];
			}
			if (dep[x] < dep[y])
				swap(x, y);
			//printf("y=%d x = %d in[y] = %d in[x] = %d\n",y, x, in[y], in[x]);
			if (comm == 6)
			{
				r = (r + query(1, 1, n, in[y], in[x])) % MOD;
				printf("%lld\n", r);
			}
			else
				update(1, 1, n, in[y], in[x], s, m);
		}
		else
		{
			scanf("%d", &x);
			if (comm != 5)
				scanf("%lld", &v);
			ll m, s;
			if (comm == 1)
			{
				s = v;
				m = 1;
			}
			else if (comm == 3)
			{
				s = 0;
				m = v;
			}
			//printf("x = %d in[x] = %d out[x] = %d\n", x, in[x], out[x]);
			if (comm == 5)
				printf("%lld\n", query(1, 1, n, in[x], out[x]));
			else
				update(1, 1, n, in[x], out[x], s, m);
		}
	}
	//printf("%lld\n", 4294967296 * 1000000000);
}
/*
15 100000
1 2
1 3
2 4
2 5
3 6
3 7
4 8
4 9
5 10
5 11
6 12
6 13
7 14
7 15
1 6 10
5 2
5 3
2 3 13 10
5 6
2 6 6 0
5 3
4 6 6 0
5 3
6 1 12
2 10 15 10
6 3 3
5 2
2 4 3 5
2 4 3 5
5 2
*/