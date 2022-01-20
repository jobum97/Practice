import sys

N = int(input())

adjList = [[] for row in range(N + 1)]

answers = [0 for _ in range(N + 1)]

# 입력 처리
for i in range(N - 1):
    s, e = map(int, sys.stdin.readline().split())
    adjList[s].append(e)
    adjList[e].append(s)

#print(adjList)
answer = ""

queue = list()
queue.append(1)
tree = set()

while len(queue) > 0:

    parent = queue.pop()
    #print("pop",parent)
    if parent in tree:
        continue
    tree.add(parent)
    for element in adjList[parent]:
        # 이미 배정되어있으면 넘겨
        if answers[element] > 0:
            continue
        answers[element] = parent
        queue.append(element)

#print(answers)
for i in range(2, N + 1):
    answer += str(answers[i]) + "\n"

print(answer, end="")
