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

struct node {
	int l, r, l2, r2;
};
node seg[4444444];
int lazy[4444444];

char info[1111111];

void merge(int now, node left, node right)
{
	seg[now].l = max(right.l - left.r, 0) + left.l;
	seg[now].r = max(left.r - right.l, 0) + right.r;
	seg[now].l2 = max(right.l2 - left.r2, 0) + left.l2;
	seg[now].r2 = max(left.r2 - right.l2, 0) + right.r2;
}

node init(int now, int s, int e)
{
	int mid = (s + e) / 2;
	node left, right;

	if (s == e)
	{
		if (info[s] == '(')
			seg[now].l2 = seg[now].r = 1;
		else
			seg[now].l = seg[now].r2 = 1;
		return seg[now];
	}
	left = init(now * 2, s, mid);
	right = init(now * 2 + 1, mid + 1, e);

	merge(now, left, right);
	return seg[now];
}
node update(int now, int s, int e, int ql, int qr)
{
	int mid = (s + e) / 2;
	node left, right;

	if (lazy[now])
	{
		swap(seg[now].l, seg[now].l2);
		swap(seg[now].r, seg[now].r2);

		lazy[now * 2] ^= 1;
		lazy[now * 2 + 1] ^= 1;
		lazy[now] = 0;
	}

	if (ql > e || qr < s)
		return seg[now];
	if (ql <= s && qr >= e)
	{
		swap(seg[now].l, seg[now].l2);
		swap(seg[now].r, seg[now].r2);

		if (s != e)
		{
			lazy[now * 2] ^= 1;
			lazy[now * 2 + 1] ^= 1;
		}
		return seg[now];
	}
	left = update(now * 2, s, mid, ql, qr);
	right = update(now * 2 + 1, mid + 1, e, ql, qr);

	merge(now, left, right);
	return seg[now];
}
node query(int now, int s, int e, int ql, int qr)
{
	int mid = (s + e) / 2;
	node retval = { 0 }, left, right;

	if (lazy[now])
	{
		swap(seg[now].l, seg[now].l2);
		swap(seg[now].r, seg[now].r2);

		lazy[now * 2] ^= 1;
		lazy[now * 2 + 1] ^= 1;
		lazy[now] = 0;
	}
	if (ql > e || qr < s)
		return retval;
	if (ql <= s && qr >= e)
		return seg[now];

	left = query(now * 2, s, mid, ql, qr);
	right = query(now * 2 + 1, mid + 1, e, ql, qr);
	retval.l = max(right.l - left.r, 0) + left.l;
	retval.r = max(left.r - right.l, 0) + right.r;
	retval.l2 = max(right.l2 - left.r2, 0) + left.l2;
	retval.r2 = max(left.r2 - right.l2, 0) + right.r2;
	return retval;
}

int main()
{
	int n, m, i, sz;

	scanf("%d", &n);
	scanf("%s", info);

	sz = strlen(info);
	scanf("%d", &m);
	init(1, 0, n - 1);
	while (m--)
	{
		int a, b, c;
		node res;
		scanf("%d%d%d", &a, &b, &c);
		if (a == 1)
			update(1, 0, n - 1, b - 1, c - 1);
		else
		{
			res = query(1, 0, n - 1, b - 1, c - 1);
			printf("%d\n", res.l + res.r + (c - b + 1));
		}
	}
}
