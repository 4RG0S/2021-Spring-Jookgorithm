import sys

n = int(sys.stdin.readline())

persons = [];

for _ in range(n):
    tempCountry, tempNumber, tempScore = sys.stdin.readline().split()
    persons.append({'country': tempCountry, 'number': tempNumber, 'score': int(tempScore)});

persons = sorted(persons, key=lambda k: k['score'])
persons.reverse();

print(persons[0]['country'], persons[0]['number']);
print(persons[1]['country'], persons[1]['number']);

if persons[0]['country'] == persons[1]['country']:
    print(persons[3]['country'], persons[3]['number']);
else:
    print(persons[2]['country'], persons[2]['number']);