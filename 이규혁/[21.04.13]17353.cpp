#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#define ll long long int
#define SIZE 111111
#define INF 1987654321
#define MOD 4294967291

using namespace std;

struct node {
	ll l, r, d;
};
node seg[444444], lazy[444444];

int info[111111];

void pgt(int now, ll l, ll r, ll d, int s, int e)
{
	int mid = (s + e) / 2;
	lazy[now * 2].l += l;
	lazy[now * 2].r += (l + (mid - s) * d);
	lazy[now * 2].d += d;
	lazy[now * 2 + 1].l += (l + ((ll)mid + 1 - s) * d);
	lazy[now * 2 + 1].r += r;
	lazy[now * 2 + 1].d += d;
}

void update(int now, int l, int r, int ql, int qr)
{
	int mid = (l + r) / 2;
	if (lazy[now].d != 0)
	{
		seg[now].l += lazy[now].l;
		seg[now].r += lazy[now].r;
		seg[now].d += lazy[now].d;
		if(l!=r)
			pgt(now, lazy[now].l, lazy[now].r, lazy[now].d, l, r);
		lazy[now].l = lazy[now].r = lazy[now].d = 0;
	}
	if (ql > r || qr < l)
		return;
	if (ql <= l && qr >= r)
	{
		seg[now].l += l - ql + 1;
		seg[now].r += r - ql + 1;
		seg[now].d++;
		if (l != r)
			pgt(now, l-ql+1, r-ql+1, 1, l, r);
		return;
	}
	update(now * 2, l, mid, ql, qr);
	update(now * 2 + 1, mid + 1, r, ql, qr);
}

ll query(int now, int l, int r, int idx)
{
	int mid = (l + r) / 2;
	//printf("now=%d s=%d e=%d l=%lld r=%lld d=%lld\n", now, l, r, seg[now].l, seg[now].r, seg[now].d);
	if (lazy[now].d != 0)
	{
		seg[now].l += lazy[now].l;
		//printf("now=%d s=%d e=%d l=%lld r=%lld d=%lld\n", now, l, r, seg[now].l, seg[now].r, seg[now].d);
		seg[now].r += lazy[now].r;
		//printf("now=%d s=%d e=%d l=%lld r=%lld d=%lld\n", now, l, r, seg[now].l, seg[now].r, seg[now].d);
		seg[now].d += lazy[now].d;
		//printf("now=%d s=%d e=%d l=%lld r=%lld d=%lld\n", now, l, r, seg[now].l, seg[now].r, seg[now].d);
		if(l!=r)
			pgt(now, lazy[now].l, lazy[now].r, lazy[now].d, l, r);
		//printf("now=%d s=%d e=%d l=%lld r=%lld d=%lld\n", now, l, r, seg[now].l, seg[now].r, seg[now].d);
		lazy[now].l = lazy[now].r = lazy[now].d = 0;
		//printf("now=%d s=%d e=%d l=%lld r=%lld d=%lld\n", now, l, r, seg[now].l, seg[now].r, seg[now].d);
	}
//	printf("now=%d s=%d e=%d l=%lld r=%lld d=%lld\n",now, l, r, seg[now].l, seg[now].r, seg[now].d);
	if (l > idx || r < idx)
		return 0;
	if (l == r)
		return seg[now].l;
	return query(now * 2, l, mid, idx) + query(now * 2 + 1, mid + 1, r, idx);
}

int main()
{
	int n,q,i,b;

	scanf("%d", &n);
	for (i = 1; i <= n; i++)
	{
		info[i] = 1000000;
		scanf("%d", &info[i]);
	}
	scanf("%d", &q);
	while (q--)
	{
		int a, b, c;

		a = 1;
		scanf("%d", &a);
		if (a == 1)
		{
			b = 1;
			c = n;
			scanf("%d%d", &b, &c);
			update(1, 1, n, b, c);
		}
		else
		{
			scanf("%d", &b);
			printf("%lld\n", info[b] + query(1, 1, n, b));
		}
	}
	/*while (1)
	{
		scanf("%d", &b);
		printf("%lld\n", info[b] + query(1, 1, n, b));
	}*/
	//scanf("%d", &b);
	//printf("%lld\n", info[b] + query(1, 1, n, b));
}