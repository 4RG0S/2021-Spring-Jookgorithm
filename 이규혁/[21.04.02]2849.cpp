#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#define ll long long int
#define SIZE 555555
#define INF 1987654321
#define MOD 4294967296

using namespace std;

struct node {
	int l, r, lm, rm, m, len;
};

node tree[888888];

void init(int now, int l, int r)
{
	int mid = (l + r) / 2;

	tree[now].l = tree[now].r = 0;
	tree[now].lm = tree[now].rm = tree[now].m = 1;
	tree[now].len = r - l + 1;
	if (l == r)
		return;
	init(now * 2, l, mid);
	init(now * 2 + 1, mid + 1, r);
}
node update(int now, int l, int r, int idx)
{
	int mid = (l + r) / 2;
	node left, right;

	if (l > idx || r < idx)
		return tree[now];
	if (l == r)
	{
		tree[now].l = tree[now].r ^= 1;
		//printf("%d %d l=%d r=%d m=%d\n", l, r, tree[now].l, tree[now].r, tree[now].m);
		return tree[now];
	}
	left = update(now * 2, l, mid, idx);
	right = update(now * 2 + 1, mid + 1, r, idx);

	tree[now].l = left.l;
	tree[now].r = right.r;
	tree[now].lm = left.lm;
	tree[now].rm = right.rm;
	if (left.lm == left.len && left.r != right.l)
		tree[now].lm += right.lm;
	if (right.rm == right.len && right.l != left.r)
		tree[now].rm += left.rm;
	tree[now].m = max(left.m, right.m);
	if (left.r != right.l)
		tree[now].m = max(tree[now].m, left.rm + right.lm);
	//printf("%d %d lm=%d rm=%d m=%d\n", l, r, tree[now].lm, tree[now].rm, tree[now].m);
	return tree[now];
}

int main()
{
	int n, q;
	scanf("%d%d", &n, &q);

	init(1, 1, n);

	while (q--)
	{
		int a;
		scanf("%d", &a);
		update(1, 1, n, a);
		printf("%d\n", tree[1].m);
	}

}
