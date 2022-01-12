nm = list(map(int, input().split()))

N = nm[0]
M = nm[1]

cards = list(map(int, input().split()))

print(N, M)
print(cards)

result = 300001
minSum = 0

# 3장의 합이 M을 넘지 않지만 제일 가까운 수
for i in range(N):
    for j in range(i + 1, N):
        for k in range(j + 1, N):
            curValue = cards[i] + cards[j] + cards[k]
            # 카드 3장의 합이 M보다 같거나 작고 최소차 갱신시
            if (curValue <= M) & (M - curValue < result):
                result = M - curValue
                minSum = curValue

print(minSum)
