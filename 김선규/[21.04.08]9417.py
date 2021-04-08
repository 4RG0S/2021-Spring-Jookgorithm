def main():
    for _ in range(int(input())):
        li = sorted(list(map(int, input().split())))
        m = 0
        for i in range(len(li)):
            for j in range(i+1,len(li)):
                a, b = li[j], li[i]
                while b != 0:
                    n = a % b
                    a = b
                    b = n
                if m < a:
                    m = a
        print(m)

if __name__ == '__main__':
    main()