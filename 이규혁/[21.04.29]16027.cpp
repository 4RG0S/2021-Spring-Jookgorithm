#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <string>
#define ll long long int
#define INF 1987654321
#define SIZE 222222
#define MOD 4294967291

using namespace std;

vector<int> info2;
int info[SIZE], n, x, idx_info[SIZE][3],from_lis[SIZE],to_lis[SIZE];
int seg[SIZE * 12];
int query(int node, int l, int r, int ql, int qr)
{
	int mid = (l + r) / 2;
	//printf("node=%d l=%d r=%d ql=%d qr=%d\n",node, l, r,ql,qr);
	if (r<ql || l>qr)
		return 0;
	if (l >= ql && r <= qr)
		return seg[node];
	return max(query(node * 2, l, mid, ql, qr), query(node * 2 + 1, mid + 1, r, ql, qr));
}
void update(int node, int l, int r, int idx, int val)
{
	int mid = (l + r) / 2;
	if (l > idx || r < idx)
		return;
	seg[node] = max(seg[node], val);
	if (l == r)
		return;
	update(node * 2, l, mid, idx, val);
	update(node * 2 + 1, mid + 1, r, idx, val);
}
int main()
{
	int i, j, res = 0;;
	scanf("%d%d", &n, &x);
	for (i = 0; i < n; i++)
	{
		scanf("%d", &info[i]);
		info2.push_back(info[i]);
		info2.push_back(info[i] - x);
		info2.push_back(info[i] + x);
	}
	sort(info2.begin(), info2.end());
	for (i = 0; i < n; i++)
	{
		int idx = lower_bound(info2.begin(), info2.end(), info[i]) - info2.begin();
		idx_info[i][0] = idx;
		idx = lower_bound(info2.begin(), info2.end(), info[i] - x) - info2.begin();
		idx_info[i][1] = idx;
		idx = lower_bound(info2.begin(), info2.end(), info[i] + x) - info2.begin();
		idx_info[i][2] = idx;
	}
	//printf("agses\n");
	for (i = 0; i < n; i++)
	{
		//printf("idx_info[%d][0]=%d\n", i, idx_info[i][0]);
		int k = query(1, 0, SIZE * 3 - 1, 0, idx_info[i][0] - 1) + 1;
		//printf("qqqq\n");
		update(1, 0, SIZE * 3 - 1, idx_info[i][0], k);
		//printf("uuuu\n");
		to_lis[i] = k;
	}
	//printf("agses\n");
	memset(seg, 0, sizeof(seg));
	for (i = n - 1; i >= 0; i--)
	{
		int k = query(1, 0, SIZE * 3 - 1, idx_info[i][0] + 1, SIZE * 3 - 1) + 1;
		update(1, 0, SIZE * 3 - 1, idx_info[i][0], k);
		from_lis[i] = k;
	}
	memset(seg, 0, sizeof(seg));
	for (i = 0; i < n; i++)
	{
		res = max(res, query(1, 0, SIZE * 3 - 1, 0, idx_info[i][0] - 1) + from_lis[i]);
		int k = query(1, 0, SIZE * 3 - 1, 0, idx_info[i][1] - 1) + 1;
		update(1, 0, SIZE * 3 - 1, idx_info[i][1], k);
	}
	memset(seg, 0, sizeof(seg));
	for (i = n - 1; i >= 0; i--)
	{
		res = max(res, query(1, 0, SIZE * 3 - 1, idx_info[i][0] + 1, SIZE * 3 - 1) + to_lis[i]);
		int k = query(1, 0, SIZE * 3 - 1, idx_info[i][2] + 1, SIZE * 3 - 1) + 1;
		update(1, 0, SIZE * 3 - 1, idx_info[i][2], k);
	}
	printf("%d", res);
}
