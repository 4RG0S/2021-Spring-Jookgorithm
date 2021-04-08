from itertools import product

def main():
    n, k = map(int, input().split())
    num = list(map(str, input().split()))
    length = len(str(n))

    while(True):
        temp = list(product(num, repeat=length))
        answer = []

        for i in temp :
            if int("".join(i)) <= n :
                answer.append(int("".join(i)))

        if len(answer) >= 1:
            print(max(answer))
            break
        else : 
            length -=1

if __name__ == '__main__':
    main()