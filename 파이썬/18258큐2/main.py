from collections import deque
import sys

N = int(input())

queue = deque()
output = ""

for i in range(N):
    order = sys.stdin.readline().split()
    size = len(queue)
    if order[0] == "push":
        queue.append(int(order[1]))
    elif order[0] == "pop":
        if size == 0:
            output += "-1\n"
        else:
            output += str(queue.popleft()) + "\n"
    elif order[0] == "size":
        output += str(size) + "\n"
    elif order[0] == "empty":
        if size == 0:
            output += "1\n"
        else:
            output += "0\n"
    elif order[0] == "front":
        if size == 0:
            output += "-1\n"
        else:
            output += str(queue[0]) + "\n"
    elif order[0] == "back":
        if size == 0:
            output += "-1\n"
        else:
            output += str(queue[size - 1]) + "\n"

print(output)
