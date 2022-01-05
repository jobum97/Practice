import sys

N = int(input())

colors = list(sys.stdin.readline().rstrip())

B_paint_cnt = 0
R_paint_cnt = 0
beforeColor = colors[0] #첫 색깔 기억

#첫 색깔 페인트 횟수 처리
if(beforeColor=='B'):
    B_paint_cnt+=1
elif(beforeColor=='R'):
    R_paint_cnt+=1

#색깔들 중 다른 색으로 변하면 횟수 카운트
for color in colors:
    if (color == 'B') & (beforeColor== 'R'):
        B_paint_cnt+=1
    elif (color == 'R') & (beforeColor == 'B'):
        R_paint_cnt += 1
    beforeColor=color #색깔 기억
    #print("B_paint_cnt :",B_paint_cnt,"R_paint_cnt :",R_paint_cnt)

result=0
#결과는 페인트 회수 적은 것+1 (페인트 횟수 많은 것을 바탕으로 삼고 적은 것을 칠하는 방식)
if(B_paint_cnt<=R_paint_cnt):
    result+=1+B_paint_cnt
else:
    result+=1+R_paint_cnt

print(result)
