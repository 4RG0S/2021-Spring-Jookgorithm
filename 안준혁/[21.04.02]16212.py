if __name__ == '__main__':
    n = int(input())

    scores = list(map(int, input().split()))

    scores.sort()

    print(*scores)