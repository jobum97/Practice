import sys

N = int(input())
data = list(map(int, sys.stdin.readline().split()))

i = 0
deadline = 0

while i != N - 1:
    nextI = i + 1
    minV = sys.maxsize
    for j in range(i+1, N):
        value = (j - i) * (1 + abs(data[i] - data[j]))
        if minV >= value:
            minV = value
            nextI = j
    deadline = max(minV, deadline)
    i = nextI

print(deadline)
