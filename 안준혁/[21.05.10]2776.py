import sys

def binarySearch(note, number):
    left = 0
    right = len(note)-1
    while left <= right:
        mid = (left + right) // 2
        if note[mid] > number:
            right = mid - 1
        elif note[mid] < number:
            left = mid + 1
        else:
            return 1
    return 0

if __name__ == '__main__':
    t = int(sys.stdin.readline())
    for _ in range(t):
        n = int(sys.stdin.readline())
        noteOne = list(map(int, sys.stdin.readline().split()))
        m = int(sys.stdin.readline())
        noteTwo = list(map(int, sys.stdin.readline().split()))
        noteOne.sort()
        for i in range(m):
            print(binarySearch(noteOne, noteTwo[i]))