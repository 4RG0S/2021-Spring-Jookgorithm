def main():
    li = [0, 1]
    for i in range(1, 1000001):
        c = 0
        for j in str(i):
            if j == '0':
                c += 1
        li.append(li[i] + c)

    for _ in range(int(input())):
        n, m = map(int, input().split())
        print(li[m+1]-li[n])


if __name__ == "__main__":
    main()