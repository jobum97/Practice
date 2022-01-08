import sys

N = int(sys.stdin.readline().rstrip())

ropes = []

for i in range(N):
    ropes.append(int(sys.stdin.readline().rstrip()))

#print(ropes)

ropes.sort(reverse=True)

Max = 0

for i in range(0, N):
    # # 로프 추가 했을 때 값이 오히려 감소하면 스탑
    # if Result > ropes[i] * (i + 1):
    #     break
    # # 최대값 갱신
    # else:
    Max =max(Max, ropes[i] * (i + 1))


print(Max)