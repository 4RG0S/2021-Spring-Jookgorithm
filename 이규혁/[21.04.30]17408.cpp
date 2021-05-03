#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <fstream>
#define ll long long int
#define SIZE 555555

using namespace std;

int info[111111];
struct seg {
	int first, second;
};
seg tree[444444];

seg init(int node, int l, int r)
{
	int mid = (l + r) / 2;
	seg left, right;
	if (l == r)
	{
		tree[node].first = info[l];
		tree[node].second = -1;
		return tree[node];
	}
	left = init(node * 2, l, mid);
	right = init(node * 2 + 1, mid + 1, r);
	if (left.first > right.first)
	{
		tree[node].first = left.first;
		tree[node].second = max(left.second, right.first);
	}
	else
	{
		tree[node].first = right.first;
		tree[node].second = max(right.second, left.first);
	}
	return tree[node];
}

seg update(int node, int l, int r, int idx, int v)
{
	int mid = (l + r) / 2;
	seg left, right;
	if (l > idx || r < idx)
		return tree[node];
	if (l == r)
	{
		tree[node].first = v;
		return tree[node];
	}
	left = update(node * 2, l, mid, idx, v);
	right = update(node * 2 + 1, mid + 1, r, idx, v);
	if (left.first > right.first)
	{
		tree[node].first = left.first;
		tree[node].second = max(left.second, right.first);
	}
	else
	{
		tree[node].first = right.first;
		tree[node].second = max(right.second, left.first);
	}
	return tree[node];
}

seg query(int node, int l, int r, int ql, int qr)
{
	int mid = (l + r) / 2;
	seg left = { 0 }, right,res;
	if (l > qr || r < ql)
		return left;
	if (l >= ql && r <= qr)
		return tree[node];
	left = query(node * 2, l, mid, ql, qr);
	right = query(node * 2 + 1, mid + 1, r, ql, qr);
	if (left.first > right.first)
	{
		res.first = left.first;
		res.second = max(left.second, right.first);
	}
	else
	{
		res.first = right.first;
		res.second = max(right.second, left.first);
	}
	return res;
}

int main()
{
	int n,m,i;

	scanf("%d", &n);
	for (i = 1; i <= n; i++)
	{
		scanf("%d", &info[i]);
	}
	init(1, 1, n);
	scanf("%d", &m);
	while (m--)
	{
		int a, b, c;
		scanf("%d%d%d", &a, &b, &c);
		if (a == 1)
		{
			update(1, 1, n, b, c);
		}
		else
		{
			seg res = query(1, 1, n, b, c);
			printf("%d\n", res.first + res.second);
		}
	}
}
