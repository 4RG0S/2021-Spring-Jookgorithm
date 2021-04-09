#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#define ll long long int
#define SIZE 555555
#define INF 1987654321
#define MOD 4294967296

using namespace std;

struct seg {
	int low, upp;
};
seg tree[8000008], lazy[8000008];

void pgt(int node, int upp, int low)
{
	if (upp >= lazy[node].low)
		lazy[node].upp = lazy[node].low = upp;
	else if (low <= lazy[node].upp)
		lazy[node].upp = lazy[node].low = low;
	else
	{
		lazy[node].upp = max(lazy[node].upp, upp);
		lazy[node].low = min(lazy[node].low, low);
	}
}

seg update(int node, int l, int r, int ql, int qr, int upp, int low)
{
	int mid = (l + r) / 2;
	seg left, right;

	if (lazy[node].upp != -1)
	{
		if (lazy[node].upp >= tree[node].low)
			tree[node].low = tree[node].upp = lazy[node].upp;
		else if (lazy[node].low <= tree[node].upp)
			tree[node].low = tree[node].upp = lazy[node].low;
		else
		{
			tree[node].low = min(tree[node].low, lazy[node].low);
			tree[node].upp = max(tree[node].upp, lazy[node].upp);
		}
		if (l != r)
		{
			pgt(node * 2, lazy[node].upp, lazy[node].low);
			pgt(node * 2 + 1, lazy[node].upp, lazy[node].low);
		}
		lazy[node].low = INF;
		lazy[node].upp = 0;

	}
	if (ql > r || qr < l)
		return tree[node];
	if (ql <= l && qr >= r)
	{
		if (upp >= tree[node].low)
			tree[node].low = tree[node].upp = upp;
		else if (low <= tree[node].upp)
			tree[node].low = tree[node].upp = low;
		else
		{
			tree[node].upp = max(tree[node].upp, upp);
			tree[node].low = min(tree[node].low, low);
		}
		if (l != r)
		{
			pgt(node * 2, upp, low);
			pgt(node * 2 + 1, upp, low);
		}
		return tree[node];
	}
	left = update(node * 2, l, mid, ql, qr, upp, low);
	right = update(node * 2 + 1, mid + 1, r, ql, qr, upp, low);
	tree[node].upp = min(left.upp, right.upp);
	tree[node].low = max(left.low, right.low);
	return tree[node];
}
int query(int node, int l, int r, int idx)
{
	int mid = (l + r) / 2;

	if (lazy[node].upp != 0 || lazy[node].low != INF)
	{
		if (lazy[node].upp >= tree[node].low)
			tree[node].low = tree[node].upp = lazy[node].upp;
		else if (lazy[node].low <= tree[node].upp)
			tree[node].low = tree[node].upp = lazy[node].low;
		else
		{
			tree[node].low = min(tree[node].low, lazy[node].low);
			tree[node].upp = max(tree[node].upp, lazy[node].upp);
		}
		if (l != r)
		{
			pgt(node * 2, lazy[node].upp, lazy[node].low);
			pgt(node * 2 + 1, lazy[node].upp, lazy[node].low);
		}
		lazy[node].upp = 0;
		lazy[node].low = INF;
	}
	if (idx > r || idx < l)
		return 0;
	if (l == r)
		return tree[node].upp;
	return query(node * 2, l, mid, idx) + query(node * 2 + 1, mid + 1, r, idx);
}

int main()
{
	int n, k, i;

	//memset(lazy, sizeof(lazy), -1);
	//fill_n(lazy, 8000005, 0);
	scanf("%d%d", &n, &k);
	while (k--)
	{
		int op, l, r, h;

		scanf("%d%d%d%d", &op, &l, &r, &h);
		if (op == 1)
			update(1, 0, n - 1, l, r, h, INF);
		if (op == 2)
			update(1, 0, n - 1, l, r, 0, h);
	}
	for (i = 0; i < n; i++)
		printf("%d\n", query(1, 0, n - 1, i));
}
