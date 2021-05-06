#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#define ll long long int
#define SIZE 55555

using namespace std;
char bit[111111];

struct seg {
	int left_bit, right_bit, left_max, right_max, zero_max, one_max, lazy, len;
};
seg tree[444444];


seg merge(seg left, seg right)
{
	seg ret;
	ret.zero_max = max(left.zero_max, right.zero_max);
	ret.one_max = max(left.one_max, right.one_max);
	ret.lazy = 0;
	if (left.right_bit == right.left_bit)
	{
		if (left.right_bit)
			ret.one_max = max(ret.one_max, left.right_max + right.left_max);
		else
			ret.zero_max = max(ret.zero_max, left.right_max + right.left_max);
	}
	ret.left_bit = left.left_bit;
	ret.right_bit = right.right_bit;
	ret.left_max = left.left_max;
	if (left.left_max == left.len)
	{
		if (left.right_bit == right.left_bit)
			ret.left_max += right.left_max;
	}
	ret.right_max = right.right_max;
	if (right.right_max == right.len)
	{
		if (right.left_bit == left.right_bit)
			ret.right_max += left.right_max;
	}
	ret.len = left.len + right.len;
	return ret;
}

seg init(int node, int l, int r)
{
	int mid = (l + r) / 2;
	seg left, right;
	tree[node].lazy = 0;
	if (l == r)
	{
		int b = bit[l] - '0';
		if (b)
			tree[node].left_bit = tree[node].right_bit = tree[node].one_max = 1;
		else
			tree[node].zero_max = 1;
		tree[node].left_max = tree[node].right_max = tree[node].len = 1;
		//printf("l=%d r=%d zeromax=%d onemax=%d lazy=%d\n", l, r, tree[node].zero_max, tree[node].one_max,tree[node].lazy);
		return tree[node];
	}
	left = init(node * 2, l, mid);
	right = init(node * 2 + 1, mid + 1, r);
	tree[node] = merge(left, right);
	//printf("l=%d r=%d zeromax=%d onemax=%d lazy=%d\n", l, r, tree[node].zero_max, tree[node].one_max, tree[node].lazy);
	return tree[node];
}

seg merge2(seg k)
{
	k.left_bit ^= 1;
	k.right_bit ^= 1;
	swap(k.zero_max, k.one_max);
	return k;
}

void pgt(int node,int l, int r)
{
	if (tree[node].lazy == 0)
		return;
	tree[node] = merge2(tree[node]);
	if (l != r)
	{
		tree[node * 2].lazy ^= 1;
		tree[node * 2 + 1].lazy ^= 1;
	}
	tree[node].lazy = 0;
}

seg update(int node, int l, int r, int ql, int qr)
{
	int mid = (l + r) / 2;
	seg left, right;

	//printf("l=%d r=%d lazy=%d\n", l, r, tree[node].lazy);
	pgt(node,l,r);
	if (l > qr || r < ql)
		return tree[node];
	if (l >= ql && r <= qr)
	{
		//printf("l=%d r=%d zeromax=%d onemax=%d\n", l, r, tree[node].zero_max, tree[node].one_max);
		tree[node] = merge2(tree[node]);
		if (l != r)
		{
			tree[node * 2].lazy ^= 1;
			tree[node * 2 + 1].lazy ^= 1;
		}
		//printf("l=%d r=%d zeromax=%d onemax=%d\n", l, r, tree[node].zero_max, tree[node].one_max);
		return tree[node];
	}
	left = update(node * 2, l, mid, ql, qr);
	right = update(node * 2 + 1, mid + 1, r, ql, qr);
	tree[node] = merge(left, right);
	//printf("l=%d r=%d zeromax=%d onemax=%d\n", l, r, tree[node].zero_max, tree[node].one_max);
	return tree[node];
}
seg query(int node, int l, int r, int ql, int qr)
{
	int mid = (l + r) / 2;
	seg left, right = { 0 }, ret;
	pgt(node, l, r);
	if (l > qr || r < ql)
		return right;
	if (l >= ql && r <= qr)
	{
		return tree[node];
	}
	left = query(node * 2, l, mid, ql, qr);
	right = query(node * 2 + 1, mid + 1, r, ql, qr);
	ret = merge(left, right);
	return ret;
}
int main()
{
	int n, q, i;

	scanf("%d%d", &n, &q);
	scanf("%s", bit);
//	printf("%d\n", tree[1].lazy);
	init(1, 0, n - 1);
//	printf("%d\n", tree[1].lazy);
	while (q--)
	{
		int t, a, b;
		scanf("%d%d%d", &t, &a, &b);
		if (t == 1)
			update(1, 0, n - 1, a - 1, b - 1);
		else
		{
			seg res = query(1, 0, n - 1, a - 1, b - 1);
			printf("%d\n", max(res.one_max, res.zero_max));
		}
	}
}
/*
5 5
11111
2 1 5
2 1 1
1 2 4
2 1 5

5 100000
10101
2 1 5
2 2 2
1 2 2
2 1 5
1 4 4
2 1 5
1 3 3
2 1 5
*/