import sys
from collections import deque

N = int(input())

Map = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(N)]

checked = [[False for _ in range(N)] for _ in range(N)]

moveSet = [(1, 0), (0, 1), (-1, 0), (0, -1)]


def makeBlock(row, col):
    queue = deque()
    queue.append((row, col))
    checked[row][col] = True
    blockCnt = 1
    while len(queue) > 0:
        cur = queue.popleft()
        for i in range(4):
            nextRow = cur[0] + moveSet[i][0]
            nextCol = cur[1] + moveSet[i][1]

            # 맵 벗어나면
            if (nextRow < 0) | (nextCol < 0) | (nextRow >= N) | (nextCol >= N):
                continue

            # 이미 갔었으면
            if checked[nextRow][nextCol]:
                continue

            if Map[nextRow][nextCol] == 1:
                checked[nextRow][nextCol] = True
                queue.append((nextRow, nextCol))
                blockCnt += 1

    return blockCnt


answers = []
for i in range(N):
    for j in range(N):
        if (not checked[i][j]) & (Map[i][j] == 1):
            answers.append(makeBlock(i, j))

answers.sort()
answer = str(len(answers)) + "\n"
for temp in answers:
    answer += str(temp) + "\n"
print(answer, end='')
