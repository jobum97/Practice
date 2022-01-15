import sys

N = int(input())

map = [sys.stdin.readline().split() for _ in range(N)]

spaces = []
teachers = []


def check(row, col):
    for i in range(row, N):
        if map[i][col] == 'S':
            return False
        elif map[i][col] == 'O':
            break

    for i in range(row, -1, -1):
        if map[i][col] == 'S':
            return False
        elif map[i][col] == 'O':
            break

    for i in range(col, N):
        if map[row][i] == 'S':
            return False
        elif map[row][i] == 'O':
            break

    for i in range(col, -1, -1):
        if map[row][i] == 'S':
            return False
        elif map[row][i] == 'O':
            break

    return True


def isValid(i, j, k):
    answer = True

    map[spaces[i][0]][spaces[i][1]] = 'O'
    map[spaces[j][0]][spaces[j][1]] = 'O'
    map[spaces[k][0]][spaces[k][1]] = 'O'

    for teacher in teachers:
        if not check(teacher[0], teacher[1]):
            answer = False
            break
    map[spaces[i][0]][spaces[i][1]] = 'X'
    map[spaces[j][0]][spaces[j][1]] = 'X'
    map[spaces[k][0]][spaces[k][1]] = 'X'
    return answer


for i in range(N):
    for j in range(N):
        if map[i][j] == 'X':
            spaces.append([i, j])
        elif map[i][j] == 'T':
            teachers.append([i, j])

isOk = False

for i in range(len(spaces)):
    if isOk:
        break
    for j in range(i + 1, len(spaces)):
        if isOk:
            break
        for k in range(j + 1, len(spaces)):
            if isValid(i, j, k):
                isOk = True
                break

if isOk:
    print("YES")
else:
    print("NO")
