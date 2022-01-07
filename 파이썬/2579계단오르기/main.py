import sys
read = sys.stdin.readline

N = int(read())
data = []
dp = [0]*(N+1)

for i in range(N):
    data.append(int(read()))

dp[0] = data[0]
# N이 1인 경우
if N == 1:
    print(dp[0])
    sys.exit(0)
dp[1] = data[1] + data[0]
#N이 2인 경우
if N == 2:
    print(dp[1])
    sys.exit(0)

dp[2] = max(data[2] + data[0], data[2] + data[1])

for i in range(3, N+1):
    dp[i] = (max(dp[i-3]+data[i-1], dp[i-2])+data[i])

#print(dp)
print(dp[N-1])




