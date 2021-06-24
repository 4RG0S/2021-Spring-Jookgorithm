import sys


def do_knapsack(value, weight, amount, size):
    opt = [[0 for x in range(size+1)]for y in range(amount+1)]
    for v in range(amount+1):
        for w in range(size+1):
            if v == 0 or w == 0:
                opt[v][w] = 0
            elif weight[v-1] > w:
                opt[v][w] = opt[v-1][w]
            else:
                opt[v][w] = max(value[v-1] + opt[v-1][w-weight[v-1]], opt[v-1][w])
    return opt[amount][size]


n, m = map(int, sys.stdin.readline().split())

itemWeight = []
itemValue = []

for _ in range(n):
    tempV, tempC, tempK = map(int, sys.stdin.readline().split())

    idx = 1
    while tempK > 0:
        tmp = min(idx, tempK)
        itemWeight.append(tempV * tmp)
        itemValue.append(tempC * tmp)
        idx *= 2
        if idx * tempV > m:
            break
        tempK -= tmp

print(do_knapsack(itemValue, itemWeight, len(itemWeight), m))
