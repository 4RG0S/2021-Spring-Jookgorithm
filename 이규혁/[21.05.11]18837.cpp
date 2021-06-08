#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#define ll long long int
#define SIZE 555555
#define INF 1000000000000000000


using namespace std;


struct seg {
	int lis;
	ll cnt;
};
int info[111111], info3[111111];
seg tree[444444];
vector<pair<int, pair<int, ll>>> info2[111111];
vector<int> output;

ll maxl(ll a, ll b)
{
	if (a > b)
		return a;
	return b;
}
ll minl(ll a, ll b)
{
	if (a > b)
		return b;
	return a;
}
seg query(int node, int l, int r, int ql, int qr)
{
	int mid = (l + r) / 2;
	seg left = { 0,0 }, right, ret;
	if (l > qr || r < ql)
		return left;
	if (l >= ql && r <= qr)
	{
		return tree[node];
	}
	left = query(node * 2, l, mid, ql, qr);
	right = query(node * 2 + 1, mid + 1, r, ql, qr);
	if (left.lis > right.lis)
		ret = left;
	else if (left.lis < right.lis)
		ret = right;
	else
	{
		ret.lis = left.lis;
		ret.cnt = left.cnt + right.cnt;
		ret.cnt = minl(ret.cnt, INF);
	}
	return ret;
}

seg update(int node, int l, int r, int idx, int lis, ll cnt)
{
	int mid = (l + r) / 2;
	seg left, right, ret;
	if (l > idx || r < idx)
		return tree[node];
	if (l == r)
	{
		if (tree[node].lis == lis)
			tree[node].cnt += cnt;
		else
			tree[node].cnt = cnt;
		tree[node].cnt = minl(tree[node].cnt, INF);
		tree[node].lis = lis;
		return tree[node];
	}
	left = update(node * 2, l, mid, idx, lis, cnt);
	right = update(node * 2 + 1, mid + 1, r, idx, lis, cnt);
	if (left.lis > right.lis)
		ret = left;
	else if (left.lis < right.lis)
		ret = right;
	else
	{
		ret.lis = left.lis;
		ret.cnt = left.cnt + right.cnt;
		ret.cnt = minl(ret.cnt, INF);
	}
	tree[node] = ret;
	return ret;
}
int v(ll a, ll b)
{
	int cnt = 0,cnt2=0,cnt3;
	double c,d,e,td,te; 

	td=d = a / 1000000;
	te=e = b / 1000000;
	c = d * e;
	while (td > 0)
	{
		td /= 10;
		cnt2++;
	}
	while (te > 0)
	{
		te /= 10;
		cnt2++;
	}
	while (c > 0)
	{
		c /= 10;
		cnt3++;
	}
	while (a)
	{
		a /= 10;
		cnt++;
	}
	while (b)
	{
		b /= 10;
		cnt++;
	}
	if (cnt2 == cnt3)
		return cnt - 1;
	else
		return cnt;
	
	return cnt;
}
int main()
{
	int n, i, l = 0, t = 0, idx = 0, j;
	ll k;
	vector<int> d;
	vector<ll> d2,d3;
	scanf("%d%lld", &n, &k);


	for (i = 1; i <= n; i++)
	{
		scanf("%d", &info[i]);
		info3[info[i]] = i;
	}
	for (i = n; i >= 1; i--)
	{
		seg res = query(1, 1, n, info[i] + 1, n);
		//printf("%d %lld\n", res.lis + 1, maxl(res.cnt,1));
		info2[info[i]].push_back({ i,{res.lis + 1, maxl(res.cnt,1)} });
		l = max(l, res.lis + 1);
		update(1, 1, n, info[i], res.lis + 1, maxl(res.cnt, 1));
	}
	//printf("%d\n", l);
	for (i = 1; i <= n; i++)
	{
		sort(info2[i].begin(), info2[i].end());
	}
	int tidx = 1987654321;
	for (i = 1; i <= n; i++)
	{
		ll s = 0;
		ll p = 1;
		d.clear();
		d2.clear();
		d3.clear();
		for (j = 0; j < info2[i].size(); j++)
		{
			if (info2[i][j].second.first == l)
			{
				s = s + info2[i][j].second.second;
				s = minl(s, INF);
				d.push_back(info2[i][j].first);
				d2.push_back(p);
				if (d3.size() == 0)
					d3.push_back(p);
				else
					d3.push_back(d3[d3.size() - 1] + p);
			}
		}
		//printf("%lld\n", s);
		if (s >= k)
		{
			tidx = i;
			output.push_back(i);
			l--;
			t = d[0];
			break;
		}
		else
			k -= s;
	}
	for (i = tidx + 1; i <= n; i++)
	{
		ll s = 0, x = 0,s2=0;
		vector<int> tmp;
		vector<ll> tmp2,tmp3;
		//printf("%d\n", tmp3.size());
		//printf("i=%d t=%d\n", i,t);
		for (j = 0; j < info2[i].size(); j++)
		{
			if (info2[i][j].second.first == l && t < info2[i][j].first)
			{
				int idx = lower_bound(d.begin(), d.end(), info2[i][j].first) - d.begin();
				int a, b;
				a = v(d3[idx - 1], info2[i][j].second.second);
				s2 = minl(d3[idx - 1] * info2[i][j].second.second, INF);
				if (a + b >= 19)
					s2 = INF;
				//printf("j=%d d3[idx-1]=%lld\n", j, d3[idx - 1]);
				s = minl(s + s2, INF);
				tmp.push_back(info2[i][j].first);
				tmp2.push_back(d3[idx-1]);
				if (tmp3.size() == 0)
					tmp3.push_back(d3[idx-1]);
				else
					tmp3.push_back(minl(tmp3[tmp3.size() - 1] + d3[idx-1], INF));
			}
		}
		//printf("i=%d s=%lld\n", i, s);
		if (s < k)
			k -= s;
		else
		{
			l--;
			d.clear();
			d2.clear();
			d3.clear();
			t = tmp[0];
			output.push_back(i);
			for (j = 0; j < tmp.size(); j++)
			{
				d.push_back(tmp[j]);
				d2.push_back(tmp2[j]);
				d3.push_back(tmp3[j]);
			}
		}
		if (l == 0)
			break;
	}
	if (l!=0)
		printf("-1");
	else
	{
		for (i = 0; i < output.size(); i++)
		{
			printf("%d ", output[i]);
		}
	}
}
/*

500
1....1.......1...
(1000),(400),200)
..2.2...2.......
(400),(200),(100)

1,
*/
/*

500
1....1.......1...
(1000),(400),200)
..2.2...2........
...........3..3..
(1,1,2)//d2
(1,2,4)//d3
(4,4)//d2
(4,8)//d3

(1,2,3)//d3
(1,2,4)//d3
(4,8)

(400),(200),(100)

1,
*/