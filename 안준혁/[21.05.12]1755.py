import sys

m, n = map(int, sys.stdin.readline().split())

numbers = {}

for i in range(m, n + 1):
    if i < 10:
        if i == 9:
            numbers["nine"] = i
        elif i == 8:
            numbers["eight"] = i
        elif i == 7:
            numbers["seven"] = i
        elif i == 6:
            numbers["six"] = i
        elif i == 5:
            numbers["five"] = i
        elif i == 4:
            numbers["four"] = i
        elif i == 3:
            numbers["three"] = i
        elif i == 2:
            numbers["two"] = i
        elif i == 1:
            numbers["one"] = i
    else:
        tempOne = i // 10
        tempTwo = i % 10
        if tempOne == 9:
            string = "nine"
        elif tempOne == 8:
            string = "eight"
        elif tempOne == 7:
            string = "seven"
        elif tempOne == 6:
            string = "six"
        elif tempOne == 5:
            string = "five"
        elif tempOne == 4:
            string = "four"
        elif tempOne == 3:
            string = "three"
        elif tempOne == 2:
            string = "two"
        elif tempOne == 1:
            string = "one"
        if tempTwo == 9:
            string += "nine"
        elif tempTwo == 8:
            string += "eight"
        elif tempTwo == 7:
            string += "seven"
        elif tempTwo == 6:
            string += "six"
        elif tempTwo == 5:
            string += "five"
        elif tempTwo == 4:
            string += "four"
        elif tempTwo == 3:
            string += "three"
        elif tempTwo == 2:
            string += "two"
        elif tempTwo == 1:
            string += "one"
        elif tempTwo == 0:
            string += "zero"
        numbers[string] = i

count = 0

for number in sorted(numbers):
    count += 1
    print(numbers[number], end=" ")
    if count == 10:
        print()
        count = 0