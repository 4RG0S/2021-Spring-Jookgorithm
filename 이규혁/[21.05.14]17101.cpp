#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#define ll long long int
#define SIZE 555555
#define MOD 11092019


using namespace std;

vector<int> g[SIZE];
int sz[SIZE], dep[SIZE], in[SIZE], top[SIZE], par[SIZE], idx, out[SIZE], seg[SIZE * 4], lazy[SIZE * 4];
int lca[SIZE][21];

int dfs(int now)
{
	int i;
	sz[now] = 1;
	for (i = 1; i < 21; i++)
		lca[now][i] = lca[lca[now][i - 1]][i - 1];
	for (i = 0; i < g[now].size(); i++)
	{
		int next = g[now][i],nextsz;
		dep[next] = dep[now] + 1;
		lca[next][0] = now;
		nextsz = dfs(next);
		sz[now] += nextsz;
		if (sz[g[now][0]] < nextsz)
			swap(g[now][0], g[now][i]);
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

void pgt(int node, int l, int r)
{
	if (lazy[node] != 0)
	{
		seg[node] += lazy[node];
		if (l != r)
		{
			lazy[node * 2] += lazy[node];
			lazy[node * 2 + 1] += lazy[node];
		}
		lazy[node] = 0;
	}
}

void update(int node, int l, int r, int ql, int qr)
{
	int mid = (l + r) / 2;
	pgt(node, l, r);
	
	if (l > qr || r < ql)
		return;
	seg[node]++;
	if (l >= ql && r <= qr)
	{
		if (l != r)
		{
			lazy[node * 2]++;
			lazy[node * 2 + 1]++;
		}
		return;
	}
	update(node * 2, l, mid, ql, qr);
	update(node * 2 + 1, mid + 1, r, ql, qr);
}
int query(int node, int l, int r, int idx)
{
	int mid = (l + r) / 2;
	pgt(node, l, r);
	if (l > idx || r < idx)
		return 0;
	if (l == r)
		return seg[node];
	return query(node * 2, l, mid, idx) + query(node * 2 + 1, mid + 1, r, idx);
}

int main()
{
	int n,i,ps=0,gs=0,now=1,j;
	scanf("%d", &n);
	for (i = 2; i <= n; i++)
	{
		int a;
		scanf("%d", &a);
		g[a].push_back(i);
		par[i] = a;
	}
	top[1]=dep[1] = 1;
	dfs(1);
	dfs2(1);
	for (i = 1; i <= n; i++)
	{
		int a = 1, b = i;
		while (top[a] != top[b])
		{
			if (dep[top[a]] < dep[top[b]])
				swap(a, b);
			update(1, 1, n, in[top[a]], in[a]);
			a = par[top[a]];
		}
		if (dep[a] > dep[b])
			swap(a, b);
		update(1, 1, n, in[a], in[b]);
		if (i == 1)
		{
			printf("1 ");
			continue;
		}
		
		if (in[i] >= in[now] && in[i] <= out[now])
		{
			a = i;
			for (j = 20; j >= 0; j--)
			{
				if (dep[lca[a][j]] >= dep[now] + 1)
					a = lca[a][j];
				if (dep[a] == dep[now] + 1)
					break;
			}
			int nowsz = query(1, 1, n, in[now]),tp,tg;
			int gsz = query(1, 1, n, in[a]);
			int pgsz = query(1, 1, n, in[par[now]]);
			if (gsz > i / 2)
			{
				tp = nowsz - gsz + ps;
				gs = gsz - 1;
				ps = tp;
				now = a;
			}
			else if (gsz <= i / 2)
			{
				if (nowsz <= i / 2)
				{
					ps = i - pgsz;
					gs = pgsz - 1;
					now = par[now];
				}
			}
		}
		else
		{
			int pgsz = query(1, 1, n, in[par[now]]);
			int nowsz = query(1, 1, n, in[now]);
			ps++;
		//printf("i=%d pgsz=%d\n", i, pgsz);
			if (ps > i / 2)
			{
				ps = i - pgsz;
				gs = pgsz - 1;
				now = par[now];
			}
			else if (ps <= i / 2)
			{
				if (nowsz <= i / 2)
				{
					ps = i - pgsz;
					gs = pgsz - 1;
					now = par[now];
				}
			}
		}
		printf("%d ", now);
	}
}