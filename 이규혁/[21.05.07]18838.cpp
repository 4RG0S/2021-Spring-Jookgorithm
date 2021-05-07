#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#define ll long long int
#define SIZE 555555


using namespace std;


struct seg {
	int lis;
	ll cnt;
};
int info[111111],info3[111111];
seg tree[444444],info2[111111];
vector<int> output;

ll maxl(ll a, ll b)
{
	if (a > b)
		return a;
	return b;
}
seg query(int node, int l, int r, int ql, int qr)
{
	int mid = (l + r) / 2;
	seg left = { 0,0 },right,ret;
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
		if (ret.cnt > 1000000000000000000)
			ret.cnt = 1000000000000000001;
	}
	return ret;
}

seg update(int node, int l, int r, int idx, seg v)
{
	int mid = (l + r) / 2;
	seg left, right, ret;
	if (l > idx || r < idx)
		return tree[node];
	if (l == r)
	{
		tree[node] = v;
		return tree[node];
	}
	left = update(node * 2, l, mid, idx, v);
	right = update(node * 2 + 1, mid + 1, r, idx, v);
	if (left.lis > right.lis)
		ret = left;
	else if (left.lis < right.lis)
		ret = right;
	else
	{
		ret.lis = left.lis;
		ret.cnt = left.cnt + right.cnt;
		if (ret.cnt > 1000000000000000000)
			ret.cnt = 1000000000000000001;
	}
	tree[node] = ret;
	return ret;
}
int main()
{
	int n,i,l=0,t=0,idx=0;
	ll k;
	scanf("%d%lld", &n, &k);

	//for (i = 1; i <= n/5; i++)
	//{
	//	info[i] = n / 5 - (i - 1);
	//	//scanf("%d", &info[i]);
	//	info3[info[i]] = i;
	//}
	//for (i = n / 5 + 1; i <= n/5*2; i++)
	//{
	//	info[i] = n/5*2 - idx;
	//	info3[info[i]] = i;
	//	idx++;
	//}
	//idx = 0;
	//for (i = n / 5 * 2 + 1; i <= n/5*3; i++)
	//{
	//	info[i] = (n/5*3) - idx;
	//	info3[info[i]] = i;
	//	idx++;
	//}
	//idx = 0;
	//for (i = n / 5 * 3 + 1; i <= n/5*4; i++)
	//{
	//	info[i] = (n/5*4) - idx;
	//	info3[info[i]] = i;
	//	idx++;
	//}
	//idx = 0;
	//for (i = n / 5 * 4 + 1; i <= n; i++)
	//{
	//	info[i] = n - idx;
	//	info3[info[i]] = i;
	//	idx++;
	//}
	for (i = 1; i <= n; i++)
	{
		scanf("%d", &info[i]);
		info3[info[i]] = i;
	}
	for (i = n; i >= 1; i--)
	{
		seg res = query(1, 1, n, info[i], n);
		//printf("%d\n", res.lis);
		info2[info[i]].lis = res.lis+1;
		info2[info[i]].cnt = maxl(res.cnt,1);
		l = max(l, info2[info[i]].lis);
		update(1, 1, n, info[i], info2[info[i]]);
	}
	//printf("%d\n", l);
	for (i = 1; i <= n; i++)
	{
		if (info2[i].lis == l && info3[t]<info3[i])
		{
			if (info2[i].cnt < k)
			{
				k -= info2[i].cnt;
				continue;
			}
			output.push_back(i);
			t = i;
			l--;
		}
		if (l == 0)
			break;
	}
	if (i > n)
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
* 
* 
* 
* 
* 
*10 9 3 2 1
* 4 3 2 1 8 7 6 5 12 11 10 9
* 3 2 1 
* 3 2 1 6 5 4 10 9 8 7
* 
* 33333
* 
* 33334 66666
* 3 2 1 6 5 4 9 8 7 12 11 10
* 2 1 4 3 6 5 8 7 12 11 10 9
*/