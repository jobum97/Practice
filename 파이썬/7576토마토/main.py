import sys
from collections import deque
C, R = map(int, sys.stdin.readline().split())

Map = [list(map(int, sys.stdin.readline().split())) for _ in range(R)]

checked = [[False for _ in range(C)] for _ in range(R)]

moveSet = [(1, 0), (0, 1), (-1, 0), (0, -1)]

firstTomato = deque()

for i in range(R):
    for j in range(C):
        if Map[i][j] == 1:
            firstTomato.append((i, j, 0))
        elif Map[i][j] == -1:
            checked[i][j] = False

while len(firstTomato) > 0:

    cur = firstTomato.popleft()
    for i in range(4):
        nextRow = cur[0] + moveSet[i][0]
        nextCol = cur[1] + moveSet[i][1]

        # 맵 벗어나면
        if (nextRow < 0) | (nextCol < 0) | (nextRow >= R) | (nextCol >= C):
            continue

        # 이미 갔었으면
        if checked[nextRow][nextCol]:
            continue

        if Map[nextRow][nextCol] == 0:
            checked[nextRow][nextCol] = True
            firstTomato.append((nextRow, nextCol, cur[2] + 1))
            Map[nextRow][nextCol] = 1

def isValid():
    for i in range(R):
        for j in range(C):
            if Map[i][j] == 0:
                return False
    return True

if isValid():
    print(cur[2])
else:
    print(-1)