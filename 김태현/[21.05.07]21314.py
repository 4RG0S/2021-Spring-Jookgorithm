s = list(input())

a = ""
m = 0

for i in range(len(s)):
    if s[i] == "M":
        m += 1
        if i == len(s) - 1:
            a += "1" * m
    else:
        a += "5" + ("0" * m)
        m = 0
m = 0
print(a)
a = ""
for i in range(len(s)):
    if s[i] == "M":
        m += 1
        if i == len(s) - 1:
            a += "1" + ("0" * (m - 1))
    else:
        if not(m == 0):
            a += "1" + ("0" * (m - 1)) + "5"
            m = 0
        else:
            a += "5"
print(a)
