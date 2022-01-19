from collections import deque
import sys

tc = int(input())
answer = ""
for k in range(tc):
    N, M = map(int, sys.stdin.readline().split())
    prioritys = list(map(int, sys.stdin.readline().split()))
    queue = list()

    temp = ""
    for q in range(len(prioritys)):
        queue.append((prioritys[q], q))

    i = 0
    j = 0
    while i < N:
        j = i + 1
        while j < N:
            if queue[i][0] < queue[j][0]:
                queue.append(queue.pop(i))
                i -= 1
                break
            j += 1
        i += 1

    for index in range(len(queue)):
        if queue[index][1] == M:
            answer += str(index + 1) + "\n"
            break

print(answer)
