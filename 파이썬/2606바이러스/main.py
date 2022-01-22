import sys

computer = int(input())
connection = int(input())

adjList = [[] for _ in range(computer + 1)]

for i in range(connection):
    s, e = map(int, sys.stdin.readline().split())
    adjList[s].append(e)
    adjList[e].append(s)

checked = [False for _ in range(computer + 1)]

answer = -1

def DFS(start):
    global answer
    checked[start] = True
    answer += 1
    for nextComputer in adjList[start]:
        if not checked[nextComputer]:
            DFS(nextComputer)


DFS(1)
print(answer)
