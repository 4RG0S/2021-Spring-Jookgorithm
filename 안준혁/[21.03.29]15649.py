from itertools import permutations


def isPrimeNumber(n):
    for divideN in range(2, n):
        if n % divideN == 0:
            return 0
    return 1


if __name__ == '__main__':
    n, m = input().split()
    n = int(n)
    m = int(m)
    numberList = []
    answerList = []

    for i in range(n):
        numberList.append(i+1)
    answerList = list(permutations(numberList, m))
    for i in range(len(answerList)):
        for j in range(m):
            print(answerList[i][j],end=' ')
        print()