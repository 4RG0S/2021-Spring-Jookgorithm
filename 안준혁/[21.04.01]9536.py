if __name__ == '__main__':
    t = int(input())

    for i in range(t):
        sound = list(input().split())
        temp = list(input().split())

        while temp[0] != 'what':
            while temp[2] in sound:
                sound.remove(temp[2])
            temp = list(input().split())

        print(*sound)