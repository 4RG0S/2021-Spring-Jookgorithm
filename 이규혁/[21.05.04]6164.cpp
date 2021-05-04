#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <fstream>
#define ll long long int
#define SIZE 555555

using namespace std;

struct seg {
	int left, right, res, sz;
};
seg tree[SIZE * 4];
int lazy[SIZE * 4];
void init(int node, int l, int r)
{
	int mid = (l + r) / 2;
	tree[node].sz = tree[node].left = tree[node].right = tree[node].res = r - l + 1;
	if (l == r)
		return;
	init(node * 2, l, mid);
	init(node * 2 + 1, mid + 1, r);
}
int query(int node, int l, int r, int sz)
{
	int mid = (l + r) / 2, left, right;

	if (lazy[node] != 0)
	{
		if (lazy[node] == 1)
			tree[node].left = tree[node].right = tree[node].res = 0;
		else
			tree[node].left = tree[node].right = tree[node].res = r - l + 1;
		if (l != r)
			lazy[node * 2] = lazy[node * 2 + 1] = lazy[node];
		lazy[node] = 0;
	}
	if (sz == tree[node].res && r - l + 1 == sz)
		return l;
	if (tree[node].res < sz || l == r)
		return -1;
	left = query(node * 2, l, mid, sz);
	if (left != -1)
		return left;
	if (tree[node * 2].right + tree[node * 2 + 1].left >= sz)
	{
		return mid - tree[node * 2].right + 1;
	}
	return right = query(node * 2 + 1, mid + 1, r, sz);
}
seg update(int node, int l, int r, int ql, int qr, int f)
{
	int mid = (l + r) / 2;
	seg left, right;

	if (lazy[node] != 0)
	{
		if (lazy[node] == 1)
			tree[node].left = tree[node].right = tree[node].res = 0;
		else
			tree[node].left = tree[node].right = tree[node].res = r - l + 1;
		if (l != r)
			lazy[node * 2] = lazy[node * 2 + 1] = lazy[node];
		lazy[node] = 0;
	}
	if (l > qr || r < ql)
		return tree[node];
	if (l >= ql && r <= qr)
	{
		if (f == 1)
		{
			tree[node].res = tree[node].left = tree[node].right = 0;
			if (l != r)
			{
				lazy[node] = lazy[node * 2] = 1;
			}
		}
		else
		{
			tree[node].res = tree[node].left = tree[node].right = r - l + 1;
			if (l != r)
			{
				lazy[node] = lazy[node * 2] = -1;
			}
		}
		return tree[node];
	}
	left = update(node * 2, l, mid, ql, qr, f);
	right = update(node * 2 + 1, mid + 1, r, ql, qr, f);
	tree[node].res = max(max(left.res, left.right + right.left), right.res);
	tree[node].left = left.left;
	if (left.left == left.sz)
		tree[node].left += right.left;
	tree[node].right = right.right;
	if (right.right == right.sz)
		tree[node].right += left.right;
	return tree[node];
}
int main()
{
	int n, m, res = 0;

	scanf("%d%d", &n, &m);
	init(1, 1, n);
	while (m--)
	{
		int a, b, c;
		scanf("%d", &a);
		if (a == 1)
		{
			scanf("%d", &b);
			int idx = query(1, 1, n, b);
			if (idx == -1)
				printf("0\n");
			else
			{
				printf("%d\n", idx);
				update(1, 1, n, idx, idx + b - 1, 1);
			}
		}
		else
		{
			scanf("%d%d", &a, &b);
			update(1, 1, n, a, min(n, a + b - 1), 0);
		}
	}
}
