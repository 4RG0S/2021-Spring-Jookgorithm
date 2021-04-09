def main():
    while True:
        n = int(input())
        if n == 0: break
        li = sorted([input() for _ in range(n)], key = lambda x:x.upper())
        print(li[0])

if __name__ == '__main__':
    main()