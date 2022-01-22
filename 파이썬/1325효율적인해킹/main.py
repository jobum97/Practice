import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

adjList = [[] for _ in range(N + 1)]

for i in range(M):
    e, s = map(int, sys.stdin.readline().split())
    adjList[s].append(e)


def BFS(start):
    checked_BFS = [False for _ in range(N + 1)]
    queue = deque()
    queue.append(start)
    count = 1
    while len(queue) > 0:
        cur = queue.popleft()
        checked_BFS[cur] = True
        for nextP in adjList[cur]:
            if not checked_BFS[nextP]:
                checked_BFS[nextP] = True
                queue.append(nextP)
                count += 1
    return count


# 모든 출발지에서 BFS 탐색 돌리고
answers = []
MAX = 0
for i in range(1, N + 1):
    cnt = BFS(i)
    if cnt > MAX:
        MAX = cnt
    answers.append((BFS(i), i))

answer = ""
for element in answers:
    if element[0] == MAX:
        answer += str(element[1]) + " "

print(answer)
