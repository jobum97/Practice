import sys

N, K = map(int, sys.stdin.readline().split())

data = []

for i in range(N):
    data.append(int(sys.stdin.readline()))

total = 0
for t in data:
    total += t


def cut(limit):
    temp = 0
    for lan in data:
        temp += lan // limit
    return temp


low = 1
high = (total // K) + 1

while low < high:
    mid = (low + high) // 2
    # 자른 개수가 목표보다 적으면 줄여야함
    if cut(mid) < K:
        high = mid
    else:
        low = mid + 1
# 상한-1
print(low - 1)
