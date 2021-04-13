from math import comb

M = int(input())
count = input().split()
countInt = []
K = int(input())
xum = 0

for i in range(M):
    countInt.append(int(count[i]))
    xum += int(countInt[i])

combSum = 0

for i in range(M):
    combSum += comb(countInt[i], K)

print(combSum / comb(xum, K))
