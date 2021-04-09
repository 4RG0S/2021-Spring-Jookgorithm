import sys
read = sys.stdin.readline
trees = {}
n = 0
while True:
    try:
        tree = read().rstrip()
        if not tree:
            break
        trees[tree] = trees.get(tree, 0) + 1
        n += 1
    except :
        break
dist = sorted(list(trees))
for i in dist:
    print(i, format(trees[i]/n*100, ".4f"))