from itertools import product

if __name__ == '__main__':
    n, m = map(int, input().split())

    numberList = product(range(1, n + 1), repeat=m)

    for i in numberList:
        print(*i)
