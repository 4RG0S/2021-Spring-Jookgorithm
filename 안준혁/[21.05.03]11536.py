import sys

n = int(sys.stdin.readline())

people = []

for _ in range(n):
    people.append(sys.stdin.readline().strip())

increasing = sorted(people)

decreasing = sorted(people, reverse=True)

if increasing == people:
    print("INCREASING")
elif decreasing == people:
    print("DECREASING")
else:
    print("NEITHER")