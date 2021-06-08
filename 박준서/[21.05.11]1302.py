import sys
read = sys.stdin.readline
n = int(read())
books = {}
for _ in range(n):
    book = read().rstrip()
    books[book] = books.get(book, 0) + 1
m = max(books.values())
sold = []
for i in books:
    if books[i] == m:
        sold.append(i)
print(sorted(sold)[0])