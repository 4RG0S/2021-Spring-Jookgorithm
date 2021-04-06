import sys

def main():
    n = int(sys.stdin.readline())
    li = sorted([int(sys.stdin.readline()) for _ in range(n)])
    print(round(sum(li)/n))
    print(li[int(n/2)])
    dic = {}
    for i in li:
        try:
            dic[i] += 1
        except:
            dic[i] = 1
    s = 0
    l = []
    for i in dic:
        if s < dic[i]:
            s = dic[i]
            l = [i]
        elif s == dic[i]:
            l.append(i)
    if len(l) > 1:
        print(l[1])
    else:
        print(l[0])
    print(li[-1]-li[0])

if __name__ == '__main__':
    main()