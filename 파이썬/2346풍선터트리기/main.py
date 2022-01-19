import sys

N = int(input())

numbers = list(map(int, sys.stdin.readline().split()))

queue = []
for i in range(len(numbers)):
    queue.append((numbers[i], i + 1))

answer = ""
index = 0
for i in range(N):
    curNum = queue.pop(index)
    if i == N - 1:
        answer += str(curNum[1]) + " "
        break
    if curNum[0] < 0:
        index = (index + curNum[0] + len(queue)) % len(queue)
    else:
        index = (index + curNum[0] - 1) % len(queue)

    print(curNum[0], curNum[1], index)
    answer += str(curNum[1])+" "

print(answer)
