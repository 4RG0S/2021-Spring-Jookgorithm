#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#define ll long long int
#define SIZE 555555
#define MOD 11092019


using namespace std;

struct seg {
	ll cnt;
	int lis;
};

int x[1111111],n;
vector<int> info[1111111];
seg segtree[4444444],t,rres;
ll maxl(ll a, ll b)
{
	if (a > b)
		return a;
	return b;
}

seg query(int node, int l, int r, int ql, int qr)
{
	int mid = (l + r) / 2;
	seg left = { 0 }, right,res;
	if (l > qr || r < ql)
		return left;
	if (l >= ql && r <= qr)
	{
		return segtree[node];
	}
	left = query(node * 2, l, mid, ql, qr);
	right = query(node * 2 + 1, mid + 1, r, ql, qr);
	if (left.lis > right.lis)
		res = left;
	else if (right.lis > left.lis)
		res = right;
	else
	{
		res.lis = left.lis;
		res.cnt = (left.cnt + right.cnt) % MOD;
	}
	return res;
}
seg update(int node, int l, int r, int idx, seg v,int f)
{
	int mid = (l + r) / 2;
	seg left, right;
	if (l > idx || r < idx)
		return segtree[node];
	if (l == r)
	{
		t.lis = segtree[node].lis;
		t.cnt = segtree[node].cnt;
		if (f == 0)
		{
			if (segtree[node].lis == v.lis)
			{
				segtree[node].cnt = (segtree[node].cnt + v.cnt) % MOD;
				if (segtree[node].cnt < 0)
					segtree[node].cnt += MOD;
			}
			else
			{
				segtree[node].lis = v.lis;
				segtree[node].cnt = v.cnt;
			}
		}
		else
		{
			segtree[node] = v;
		}
		return segtree[node];
	}
	left = update(node*2, l, mid, idx, v,f);
	right = update(node * 2+1, mid + 1, r, idx, v,f);
	if (left.lis > right.lis)
		segtree[node] = left;
	else if (right.lis > left.lis)
		segtree[node] = right;
	else
	{
		segtree[node].lis = left.lis;
		segtree[node].cnt = (left.cnt + right.cnt) % MOD;
		if (segtree[node].cnt < 0)
			segtree[node].cnt += MOD;
	}
	return segtree[node];
}

void dfs(int now)
{
	int i;
	seg res=query(1,0,1000000,0,x[now]);
	res.lis++;
	res.cnt = maxl(res.cnt, 1);
	if (rres.lis < res.lis)
		rres = res;
	else if (rres.lis == res.lis)
		rres.cnt = (rres.cnt + res.cnt) % MOD;
	//printf("now=%d xnow=%d %d %lld\n", now, x[now],rres.lis, rres.cnt);
	update(1, 0, 1000000, x[now], res, 0);

	for (i = 0; i < info[now].size(); i++)
		dfs(info[now][i]);
	update(1, 0, 1000000, x[now], t, 1);
}

int main()
{
	int i;

	scanf("%d", &n);
	for (i = 1; i <= n; i++)
	{
		scanf("%d", &x[i]);
	}
	for (i = 2; i <= n; i++)
	{
		int a;
		scanf("%d", &a);
		info[a].push_back(i);
	}
	dfs(1);
	printf("%d %lld", rres.lis, rres.cnt);
}
