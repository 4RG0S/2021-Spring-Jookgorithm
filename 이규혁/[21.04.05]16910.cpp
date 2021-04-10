#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#define ll long long int
#define SIZE 111111
#define INF 1987654321
#define MOD 4294967291

using namespace std;

int op[SIZE],seg[SIZE*10],lazy[SIZE*10];
ll l[SIZE], r[SIZE];
vector<ll> inp;

void pgt(int node, int flag)
{
	if (flag == 2)
	{
		if (lazy[node] == 1)
			lazy[node] = 0;
		else if (lazy[node] == 0)
			lazy[node] = 1;
		else if (lazy[node] == 2)
			lazy[node] = INF;
		else
			lazy[node] = 2;
	}
	else
		lazy[node] = flag;
}

int update(int node, int s, int e, int ql, int qr, int flag)
{
	int mid = (s + e) / 2,left,right;

	if (lazy[node] != INF)
	{
		if (s != e)
		{
			pgt(node * 2, lazy[node]);
			pgt(node * 2 + 1, lazy[node]);
		}
		if (lazy[node] == 2)
		{
			if (seg[node] == 1)
				seg[node] = 0;
			else if (seg[node] == 0)
				seg[node] = 1;
		}
		else
			seg[node] = lazy[node];
		lazy[node] = INF;
	}

	if (ql > e || qr < s)
		return seg[node];
	if (ql <= s && qr >= e)
	{
		if (flag == 2)
		{
			if (seg[node] == 1)
				seg[node] = 0;
			else if (seg[node] == 0)
				seg[node] = 1;
		}
		else
			seg[node] = flag;
		if (s != e)
		{
			pgt(node * 2, flag);
			pgt(node * 2 + 1, flag);
		}
		//printf("l=%d r=%d seg=%d\n", s, e, seg[node]);
		return seg[node];
	}
	left = update(node * 2, s, mid, ql, qr, flag);
	right = update(node * 2 + 1, mid + 1, e, ql, qr, flag);

	seg[node] = -1;
	if (left == 1 && right == 1)
		seg[node] = 1;
	if (left == 0 && right == 0)
		seg[node] = 0;
	//printf("l=%d r=%d seg=%d\n", s, e, seg[node]);
	return seg[node];
}

int query(int node, int s, int e)
{
	int mid = (s + e) / 2;
	int left,right;
	//printf("l=%d r=%d lazy=%d\n", s, e, lazy[node]);
	if (lazy[node] != INF)
	{
		if (s != e)
		{
			pgt(node * 2, lazy[node]);
			pgt(node * 2 + 1, lazy[node]);
		}
		if (lazy[node] == 2)
		{
			if (seg[node] == 1)
				seg[node] = 0;
			else if (seg[node] == 0)
				seg[node] = 1;
		}
		else
			seg[node] = lazy[node];
		lazy[node] = INF;
	}
	//printf("l=%d r=%d seg=%d\n", s, e, seg[node]);
	if (s == e)
	{
		if (seg[node] == 0 || seg[node]==-1)
			return s-1;
		return e;
	}
	if (seg[node] == 1)
		return e;
	if (seg[node] == 0)
		return s-1;
	left = query(node * 2, s, mid);
	if (left == mid)
	{
		right = query(node * 2 + 1, mid + 1, e);
		return right;
	}
	else
		return left;

}

int main()
{
	int n,i,f=0;
	scanf("%d", &n);

	fill(lazy, lazy + SIZE * 10, INF);
	for (i = 0; i < n; i++)
	{
		scanf("%d%lld%lld", &op[i], &l[i], &r[i]);
		inp.push_back(l[i]);
		inp.push_back(r[i]);
		if (l[i] != 1)
			inp.push_back(l[i] - 1);
		if (r[i] != 1)
			inp.push_back(r[i] - 1);
	}
	sort(inp.begin(), inp.end());
	if (inp[0] != 1)
	{
		inp.push_back(1);
		f++;
	}
	if (inp[inp.size() - 1] != (ll)1e18)
	{
		inp.push_back((ll)1e18);
		f++;
	}
	sort(inp.begin(), inp.end());
	inp.erase(unique(inp.begin(), inp.end()), inp.end());

	for(i=0;i<n;i++)
	{
		int s = lower_bound(inp.begin(), inp.end(), l[i]) - inp.begin();
		int e = lower_bound(inp.begin(), inp.end(), r[i]) - inp.begin(),idx;
		ll res;
		//printf("%d %d\n", s, e);
		if (op[i] == 1)
			update(1, 0, inp.size(), s, e, 1);
		else if(op[i]==2)
			update(1, 0, inp.size(), s, e, 0);
		else
			update(1, 0, inp.size(), s, e, 2);
		idx = query(1, 0, inp.size());
		if (idx < 0)
			res = 1;
		else
			res = inp[idx] + 1;
		printf("%lld\n", res);
	}

}

/*
3
3 19876543219 30321654987
3 1 95843259781
3 19876543219 30321654980
*/