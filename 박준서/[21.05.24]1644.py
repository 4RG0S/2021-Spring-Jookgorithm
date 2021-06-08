n = int(input())
if n == 1:
    print(0)
    exit()
sieve = [True for _ in range(n+1)]
for i in range(2, int(n**0.5)+1):
    if sieve[i]:
        for j in range(i**2, n+1, i):
            sieve[j] = False

prime = [i for i in range(2, n+1) if sieve[i] == True]
start, end = 0, 0
s = prime[0]
count = 0
while start != len(prime):
    if s >= n:
        if s == n:
            count += 1
        s -= prime[start]
        start += 1
    else:
        end += 1
        if end == len(prime):
            break
        s += prime[end]
print(count)