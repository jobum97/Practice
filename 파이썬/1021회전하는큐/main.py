import sys

N, M = map(int, sys.stdin.readline().split())

numbers = list(map(int, sys.stdin.readline().split()))

queue = [i + 1 for i in range(N)]

left = 0
right = len(queue) - 1
answer = 0


def POP(target):
    global right
    global left
    global answer
    for i in range(len(queue)):
        if queue[i] == target:
            targetIndex = i
            break

    # print("계산전", targetIndex, left, right)
    if right < targetIndex:
        moveRight = len(queue) - targetIndex + right + 1
    else:
        moveRight = right - targetIndex + 1
    if targetIndex < left:
        moveLeft = len(queue) - right + targetIndex - 1
    else:
        moveLeft = targetIndex - left

    # print("움직임 비교", moveLeft, moveRight)
    queue.pop(targetIndex)
    if len(queue) > 0:
        left = targetIndex
        right = (targetIndex + len(queue) - 1) % len(queue)

    # print("T,L,R", targetIndex, left, right)
    answer += min(moveLeft, moveRight)


for number in numbers:
    POP(number)

print(answer)
