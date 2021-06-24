import sys


def do_knapsack(value, weight, amount, size):
    opt = [[0 for x in range(size+1)]for y in range(amount+1)]
    for i in range(amount+1):
        for w in range(size+1):
            # if i=0 -> 0
            if i == 0 or w == 0:
                opt[i][w] = 0
            elif weight[i-1] > w:
                opt[i][w] = opt[i-1][w]
            else:
                opt[i][w] = max(value[i-1] + opt[i-1][w-weight[i-1]], opt[i-1][w])
    return opt[amount][size]


n = int(sys.stdin.readline())

weights = list(map(int,sys.stdin.readline().split()))
values = list(map(int,sys.stdin.readline().split()))

print(do_knapsack(values, weights, n, 99))