import sys
from collections import deque
from queue import PriorityQueue

N, M = map(int, sys.stdin.readline().split())

Map = [list(sys.stdin.readline().rstrip()) for _ in range(N)]
checked = [[False for col in range(M)] for row in range(N)]

# for i in range(N):
#     print(Map[i])

# (0,0) -> (N-1, M-1)

moveSet = [(1, 0), (0, 1), (-1, 0), (0, -1)]


def BFS():
    global N, M
    queue = PriorityQueue()
    queue.put((1, 0, 0))  # 이동해야하는 칸수, row, col
    checked[0][0] = True
    while not queue.empty():
        cur = queue.get()
        #print(cur)
        # 도착 시 이동 칸 수 return
        if (cur[1] == N - 1) & (cur[2] == M - 1):
            return cur[0]

        for i in range(4):
            nextRow = cur[1] + moveSet[i][0]
            nextCol = cur[2] + moveSet[i][1]

            # 맵 벗어나면 컷
            if (nextRow < 0) | (nextCol < 0) | (nextRow >= N) | (nextCol >= M):
                continue

            # 가는 곳 아니면 컷
            if Map[nextRow][nextCol] == '0':
                continue

            # 간 적 없으면 ㄱㄱ
            if not checked[nextRow][nextCol]:
                queue.put((cur[0] + 1, nextRow, nextCol))
                checked[nextRow][nextCol]=True


print(BFS())
