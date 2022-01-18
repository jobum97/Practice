import sys

N, M = map(int, input().split())

trees = list(map(int,sys.stdin.readline().split()))

print(N,M)
print(trees)
def takeTrees(height):
    Sum = 0
    for tree in trees:
        temp = tree - height
        if temp > 0:
            Sum += temp

    return Sum


i = 0
j = max(trees)

while i < j:
    pivot = (i + j) // 2

    #print(i, pivot, j, takeTrees(pivot))
    # 가져가는 나무가 많으면 높이 올려야함
    if M <= takeTrees(pivot):
        i = pivot + 1
    else:
        j = pivot

print(i-1)
