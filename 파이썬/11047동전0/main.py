import sys

N, M = input().split()
N = int(N)
M = int(M)
#print(N, M)

coinValues = []

for i in range(N):
    coinValues.append(int(sys.stdin.readline().rstrip()))

#print(coinValues)

totalCoinCnt = 0
coinCnt = 0
coinValues.sort(reverse=True)

# 동전 액수가 높은 것 부터 할당한다
for i in range(N):
    # 목표 가격 보다 동전 가격이 같거나 낮으면 동전 처리
    if M >= coinValues[i]:
        coinCnt = M // coinValues[i]
        M -= coinValues[i] * coinCnt
        totalCoinCnt += coinCnt

print(totalCoinCnt)
