if __name__ == '__main__':
    n = int(input())
    left = 0
    right = n
    answer = n
    while left <= right:
        mid = (left + right) // 2
        if mid**2 >= n:
            right = mid - 1
            if answer > mid:
                answer = mid
        else:
            left = mid + 1
    print(answer)