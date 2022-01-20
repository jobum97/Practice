import sys
import heapq

N = int(input())
data = list(map(int, sys.stdin.readline().split()))

powerTable = [[0 for col in range(N)] for row in range(N)]

# dp = [0 for i in range(N)]

# right = 0
# left = sys.maxsize
possiblePowers = []
# 이동할 때 드는 에너지테이블 계산하며 최대에너지 최소 에너지 계산
for i in range(N):
    for j in range(i + 1, N):
        curP = (j - i) * (1 + abs(data[i] - data[j]))
        possiblePowers.append(curP)
        # right = max(curP, right)
        # left = min(curP, left)
        powerTable[i][j] = curP

possiblePowers.sort()


# 파워테이블 돌면서 현재 상한선으로 최종 목적지에 도달할 수 있는지 판별하는 메소드
def isVaild(limit):
    global N

    possiblePoints = [False] * N

    for row in range(N):
        for col in range(row + 1, N):
            if possiblePoints[N-1]:
                return True
            if possiblePoints[col]:
                continue
            if powerTable[row][col] <= limit:
                possiblePoints[col] = True
    return False
    # queue = []
    # for i in range(1, N):
    #     if powerTable[0][i] <= limit:
    #         queue.append(i)
    #
    # while len(queue) > 0:
    #     cur = queue.pop()
    #
    #     if cur == N - 1:
    #         return True
    #     for i in range(cur + 1, N):
    #         if powerTable[cur][i] <= limit:
    #             queue.append(i)
    # return False


left = 0
right = len(possiblePowers) - 1

# 이분탐색 하한
while left < right:
    mid = (left + right) // 2
    # 현재 상한선으로 해결이 된다는 의미는 더 줄여도 될 수도?
    if isVaild(possiblePowers[mid]):
        right = mid
    else:
        left = mid + 1

print(possiblePowers[left])
