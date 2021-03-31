n = int(input())
nums = sorted(list(map(int, input().split())))
result = 0
for i in range(len(nums)):
    result += sum(nums[:i+1])
print(result)