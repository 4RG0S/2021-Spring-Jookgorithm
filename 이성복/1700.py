n, k = map(int, input().split())
name = list(map(int, input().split()))

# 현재 콘센트에 꽃혀있는 전자기기
now = set()
for _ in range(n):
    now.add(name.pop(0))

count = 0
while name:
    tmp = name.pop(0)
    if tmp not in now:
        if len(now) < n:
            now.add(tmp)
            continue
        _max = 0
        flag = True
        for i in now:   # 현재시점으로부터 가장 늦게 사용하는 전자기기를 뽑는다.
            try:
                _max = max(_max, name.index(i))
            except ValueError:  # 이후에 사용하지 않는 전자기기가 있다면 그것을 뽑는다.
                flag = False
                now.remove(i)
                now.add(tmp)
                count += 1
                break
        if flag:
            now.remove(name[_max])
            now.add(tmp)
            count += 1

print(count)
