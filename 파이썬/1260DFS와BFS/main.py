import sys
from collections import deque

# N은 정점의 개수, 간선의 개수 M, 시작 번호 V
N, M, V = map(int, sys.stdin.readline().split())

# 인접 리스트 만들기
adjList = [[] for row in range(N + 1)]

for i in range(M):
    s, e = map(int, sys.stdin.readline().split())
    adjList[s].append(e)
    adjList[e].append(s)

for i in range(1, N + 1):
    adjList[i].sort()

# DFS 구현
# 방문한지 체크
checked_DFS = [False for _ in range(N + 1)]
checked_BFS = [False for _ in range(N + 1)]
answer_DFS = ""
answer_BFS = ""


# 재귀 함수로 구현
def DFS(start):
    global answer_DFS
    for nextP in adjList[start]:
        # 가본적 없으면 가고, 갔다고 체크, 그리고 DFS() 재귀
        if not checked_DFS[nextP]:
            answer_DFS += " " + str(nextP)
            checked_DFS[nextP] = True
            DFS(nextP)


def BFS(start):
    global answer_BFS
    queue = deque()
    queue.append(start)

    while len(queue) > 0:
        cur = queue.popleft()
        checked_BFS[cur] = True
        for nextP in adjList[cur]:
            if not checked_BFS[nextP]:
                answer_BFS += " " + str(nextP)
                checked_BFS[nextP] = True
                queue.append(nextP)


checked_DFS[V] = True
answer_DFS += str(V)
answer_BFS += str(V)
DFS(V)
BFS(V)
print(answer_DFS)
print(answer_BFS)
