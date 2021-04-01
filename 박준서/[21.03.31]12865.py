def kanpsack(k,inputw,val):
    n = len(val)
    m = [[0 for i in range(k+1)] for i in range(n)]
    for i in range(1,n):
        for j in range(k+1):
            value = val[i]
            weight = inputw[i]
            if weight > j:
                m[i][j] = m[i-1][j]
            else:
                m[i][j] = max(m[i-1][j], m[i-1][j-weight]+value)
    return m[n-1][k]

n, k = map(int, input().split())
inputw = [0]
val = [0]
for _ in range(n):
    w, v = map(int, input().split())
    inputw.append(w)
    val.append(v)
print(kanpsack(k,inputw,val))