from collections import deque
import sys

class Point:
    def __init__(self, row, col):
        self.row = row
        self.col = col


def makeBlock(i, j, height):
    # BFS 탐색하며 안전영역 탐색
    queue = deque()

    queue.append(Point(i, j))
    checked[i][j] = True
    while len(queue) != 0:
        cur = queue.popleft()
        #print("탐색 중 ", cur.row, cur.col)
        #print(checked)
        for k in range(4):
            nextRow = cur.row + moveSet[k][0]
            nextCol = cur.col + moveSet[k][1]

            # 맵 벗어나면 컷
            if (nextRow < 0) | (nextRow >= N) | (nextCol < 0) | (nextCol >= N):
                #print("맵밖", nextRow, nextCol)
                continue

                # 이미 갔던 곳 컷
            if checked[nextRow][nextCol]:
                # print("갔던곳", nextRow, nextCol)
                continue
            # 물에 잠기는 곳이면 컷
            if map[nextRow][nextCol] <= height:
                checked[nextRow][nextCol] = True
                #print("잠김", nextRow, nextCol)
                continue

            queue.append(Point(nextRow, nextCol))
            checked[nextRow][nextCol] = True
            #print("탐색 이어감", nextRow, nextCol)


N = int(input())

map = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
moveSet = [[1, 0], [0, 1], [-1, 0], [0, -1]]
# 지역에서 최대 높이구함
maxHeight = 0
for i in range(N):
    for j in range(N):
        maxHeight = max(maxHeight, map[i][j])


answer = 0
# 최대 높이면 다 잠겨 영역 0개 이기에 최대높이 전까지 돌려봄
for height in range(1, maxHeight):
    checked = [[False for col in range(N)] for row in range(N)]
    temp = 0
    for i in range(N):
        for j in range(N):
            # 이미 확인한 곳은 건너뛴다
            if checked[i][j]:
                continue

            # 강수량 보다 같거나 낮으면 잠김
            if map[i][j] <= height:
                #print("잠김체크",i,j)
                checked[i][j] = True
            else:
                #print(i, j, height, checked)
                makeBlock(i, j, height)
                temp += 1
                #print(i, j,height, checked)

    #print(temp)
    answer = max(answer, temp)

print(answer)
