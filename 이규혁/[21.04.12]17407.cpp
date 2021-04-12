#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <string.h>
#define ll long long int
#define SIZE 111111
#define INF 1987654321
#define MOD 4294967291

using namespace std;

struct node {
	int l, r, l2, r2;
};

char s[111111];
node seg[444444];

node merge(node left, node right)
{
	node res;

	res.l = left.l + max(right.l - left.r, 0);
	res.r = right.r + max(left.r - right.l, 0);
	res.l2 = left.l2 + max(right.l2 - left.r2, 0);
	res.r2 = right.r2 + max(left.r2 - right.l2, 0);
	return res;
}

node init(int now, int l, int r)
{
	int mid = (l + r) / 2;
	node left, right;
	if (l == r)
	{
		if (s[l] == ')')
			seg[now].l = seg[now].r2 = 1;
		else
			seg[now].r = seg[now].l2 = 1;
		//printf("s=%d e=%d l=%d r=%d l2=%d r2=%d\n", l,r, seg[now].l, seg[now].r, seg[now].l2, seg[now].r2);
		return seg[now];
	}

	left = init(now * 2, l, mid);
	right = init(now * 2 + 1, mid + 1, r);
	seg[now] = merge(left, right);
	//printf("s=%d e=%d l=%d r=%d l2=%d r2=%d\n", l,r, seg[now].l, seg[now].r, seg[now].l2, seg[now].r2);
	return seg[now];
}
node update(int now, int l, int r, int idx)
{
	int mid = (l + r) / 2;
	node left, right;
	if (l > idx || r < idx)
		return seg[now];
	if (l == r)
	{
		swap(seg[now].l, seg[now].l2);
		swap(seg[now].r, seg[now].r2);
		//printf("s=%d e=%d l=%d r=%d l2=%d r2=%d\n", l, r, seg[now].l, seg[now].r, seg[now].l2, seg[now].r2);
		return seg[now];
	}
	left = update(now * 2, l, mid, idx);
	right = update(now * 2 + 1, mid + 1, r, idx);
	seg[now] = merge(left, right);
	//printf("s=%d e=%d l=%d r=%d l2=%d r2=%d\n", l, r, seg[now].l, seg[now].r, seg[now].l2, seg[now].r2);

	return seg[now];
}

int main()
{
	int n, i,cnt=0,sz;
	scanf("%s", s);
	scanf("%d", &n);
	sz = strlen(s);

	init(1, 0, sz - 1);

	while (n--)
	{
		int a;
		scanf("%d", &a);

		update(1, 0, sz - 1, a - 1);
		if (seg[1].l == 0 && seg[1].r == 0)
			cnt++;
	}
	printf("%d", cnt);

}