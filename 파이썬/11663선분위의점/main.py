import sys

N, M = map(int, sys.stdin.readline().split())
points = list(map(int, sys.stdin.readline().split()))
points.append(sys.maxsize)
tc = []

for i in range(M):
    start, end = map(int, sys.stdin.readline().split())
    tc.append((start, end))

points.sort()

# 시작점은 하한으로 찾는다
def binarySearch(target):
    low = 0
    high = len(points) - 1

    while low < high:
        mid = (low + high) // 2
        if target <= points[mid]:
            high = mid
        else:
            low = mid + 1

    return low

# 끝점은 딱 맞는 지점이 없으면 하한-1 이면 되는데 있으면 예외발생
def binarySearch_End(target):
    low = 0
    high = len(points) - 1

    while low < high:
        mid = (low + high) // 2
        if target < points[mid]:
            high = mid
        elif target > points[mid]:
            low = mid + 1
        else:
            return mid

    return low - 1


answer = ""

for t in tc:
    answer += str(binarySearch_End(t[1]) - binarySearch(t[0]) + 1) + "\n"
print(answer)
