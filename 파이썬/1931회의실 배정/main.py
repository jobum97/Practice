import sys

N = int(input())

meetings = []

for i in range(N):
    meetings.append(list(map(int, sys.stdin.readline().split())))

# 회의 끝나는 시간이 빠른 순으로, 같으면 시작시간이 빠른 순으로 정렬
meetings.sort(key=lambda x:(x[1], x[0]))

print(meetings)

answer = 0
curTime = 0
for meeting in meetings:
    # 회의 시작 시간이 현재보다 뒤면
    if meeting[0] >= curTime:
        curTime = meeting[1]
        answer += 1

print(answer)