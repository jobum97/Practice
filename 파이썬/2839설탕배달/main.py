N = int(input())

dp = [-1 for i in range(5001)]
dp[3] = 1
dp[5] = 1
for i in range(6,N+1):
    if (dp[i-3] == -1) & (dp[i-5] != -1):
        dp[i] = dp[i - 5] + 1
        #print("case 1 :", i, dp[i])
    elif (dp[i - 3] != -1) & (dp[i - 5] == -1):
        dp[i] = dp[i - 3] + 1
        #print("case 2 :", i, dp[i])
    elif (dp[i - 3] != -1) & (dp[i - 5] != -1):
        dp[i] = min(dp[i-3],dp[i-5])+1
        #print("case 3 :", i, dp[i])

print(dp[N])




