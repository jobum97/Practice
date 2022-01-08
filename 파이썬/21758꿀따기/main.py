import sys

N = int(input())

data = list(map(int, sys.stdin.readline().split()))

# 누적합 배열
sum = []
sum.append(data[0])
for i in range(1, N):
    sum.append(sum[i-1]+data[i])

# print(data)
# print(sum)

Max = 0
# case 꿀벌벌 (꿀 맨 왼쪽 고정 맨 오른쪽 벌 고정)
for i in range(1, N-1):
    Max = max(sum[N-2]-data[i]+sum[i-1], Max)

# case 벌벌꿀 (꿀 맨 오른쪽 고정 맨 왼쪽 벌 고정)
for i in range(1, N-1):
    Max = max(sum[N-1]-data[0]-data[i]+sum[N-1]-sum[i], Max)

# case 벌꿀벌 -이 경우는 꿀의 위치가 i
for i in range(1, N-1):
    Max = max(sum[N-2]-data[0]+data[i], Max)

print(Max)