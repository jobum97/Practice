CP = list(map(int, input().split()))

C = CP[0]
P = CP[1]

map = list(map(int, input().split()))

print(C, P)
print(map)

answer = 0

if P == 1:
    answer+=C
    for i in range(3,C):
        if (map[i] == map[i - 1]) & (map[i - 2] == map[i - 1])& (map[i - 3] == map[i - 2]):
            answer += 1

elif P == 2:
    for i in range(C):
        if (i >= 1) & (map[i - 1] == map[i]):
            answer += 1

elif P == 3:
    for i in range(C):
        # 세운 경우
        if (i >= 1) & (map[i - 1] - map[i] == 1):
            answer += 1
        # 눕힌 경우
        if (i >= 2) & (map[i - 2] == map[i - 1]) & (map[i] - map[i - 1] == 1):
            answer += 1
elif P == 4:
    for i in range(C):
        # 세운 경우
        if (i >= 1) & (map[i] - map[i - 1] == 1):
            answer += 1
        # 눕힌 경우
        if (i >= 2) & (map[i] == map[i - 1]) & (map[i - 2] - map[i - 1] == 1):
            answer += 1
elif P == 5:
    for i in range(C):
        # ㅏ,ㅓ
        if (i >= 1) & (abs(map[i] - map[i - 1]) == 1):
            answer += 1
        # ㅗ
        if (i >= 2) & (map[i] == map[i - 1]) & (map[i - 2] == map[i - 1]):
            answer += 1
        # ㅜ
        if (i >= 2) & (map[i] - map[i - 1] == 1) & (map[i - 2] - map[i - 1] == 1):
            answer += 1
elif P == 6:
    for i in range(C):
        # 같같
        if (i >= 1) & (map[i] == map[i - 1]):
            answer += 1
        if (i >= 1) & (map[i - 1] - map[i] == 2):
            answer += 1
        if (i >= 2) & (map[i] == map[i - 1]) & (map[i - 1] - map[i - 2] == 1):
            answer += 1
        # 같같같
        if (i >= 2) & (map[i] == map[i - 1]) & (map[i - 2] == map[i - 1]):
            answer += 1
elif P == 7:
    for i in range(C):
        # 같같
        if (i >= 1) & (map[i] == map[i - 1]):
            answer += 1
        if (i >= 1) & (map[i] - map[i - 1] == 2):
            answer += 1
        if (i >= 2) & (map[i - 2] == map[i - 1]) & (map[i - 1] - map[i] == 1):
            answer += 1
        # 같같같
        if (i >= 2) & (map[i] == map[i - 1]) & (map[i - 2] == map[i - 1]):
            answer += 1

print(answer)
