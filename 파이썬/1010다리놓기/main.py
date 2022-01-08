import sys

read = sys.stdin.readline

N = int(read())

testcase = []
for _ in range(N):
    testcase.append(list(map(int, input().split())))

dp = [[0 for col in range(31)] for row in range(31)]

for w in range(1, 31):
    for e in range(w, 31):
        # 초기화1: 서쪽 동쪽 도시 숫자 같으면 1
        if w == e:
            dp[w][e] = 1
        # 초기화2 : 서쪽 도시 숫자 1개이면 동쪽 도시 숫자가 경우의 수
        elif w == 1:
            dp[w][e] = e
        # 점화식 : (서쪽 도시를 1 추가했다고 생각) 서쪽 도시의 맨위와 동쪽의 맨위가 이어졌을 때의 경우의 수 +
        # 동쪽의 맨위를 배제하는 경우의 수 (= dp[w][e-1])
        else:
            dp[w][e] = dp[w-1][e-1] + dp[w][e-1]

# for w in range(1, 31):
#     print(dp[w])

for tc in testcase:
    print(dp[tc[0]][tc[1]])