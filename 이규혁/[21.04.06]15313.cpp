#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <algorithm>
#include <memory.h>
#define ll long long int

using namespace std;

pair<pair<int, int>, pair<ll, ll>> info[2222];
ll h[2222];
int y[2222];

ll seg[8080];



int main()
{
	int n, i, j, idx1 = 1, idx2 = 1;
	ll m, res = 1987654321;

	scanf("%d%lld", &n, &m);

	for (i = 1; i <= n; i++)
	{
		info[i].first.first = info[i].first.second = info[i].second.first = info[i].second.second = i;
		scanf("%d%d%lld%lld", &info[i].first.first, &info[i].first.second, &info[i].second.first, &info[i].second.second);
		h[i] = info[i].second.second;;
		y[i] = info[i].first.second;
	}
	sort(info + 1, info + n + 1);
	sort(h + 1, h + n + 1);
	sort(y + 1, y + n + 1);

	while (idx1 <= idx2)
	{
		fill(seg, seg + 8080, 0);
		//printf("idx1=%d idx2=%d h[idx1]=%lld h[idx2]=%lld\n", idx1, idx2,h[idx1],h[idx2]);
		for (i = 1; i <= n; i++)
		{
			ll t=-1;
			int idx = lower_bound(y + 1, y + n + 1, info[i].first.second) - y;

			//printf("i=%d h[i]=%lld\n", i, info[i].second.second);
			if (info[i].second.second >= h[idx1] && info[i].second.second <= h[idx2])
			{
				t = query(1, 1, n, 1, idx)+info[i].second.first;
				update(1, 1, n, idx, t);
				if (t >= m)
				{
					res = minl(res, h[idx2] - h[idx1]);
					break;
				}
			}
		//	printf("i=%d t=%lld\n", i, t);


		}
		if (i <= n)
			idx1++;
		else
			idx2++;
		if (idx2 > n)
			break;
	}
	if (res == 1987654321)
		printf("-1");
	else
		printf("%lld", res);
}