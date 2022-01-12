import sys


def swap(i, j, nextRow, nextCol):
    temp = board[i][j]
    board[i][j] = board[nextRow][nextCol]
    board[nextRow][nextCol] = temp


# 가로 검사
def checkHorizon(row):

    maxCandy = 0
    seq = 1

    for i in range(1, N):
        # 이전 캔디와 다르면
        if board[row][i] != board[row][i-1]:
            maxCandy = max(maxCandy, seq)
            seq = 1
        else:
            seq += 1

    maxCandy = max(maxCandy, seq)
    return maxCandy

# 세로 검사
def checkVertical(col):
    maxCandy = 0
    seq = 1
    for i in range(1, N):
        # 이전 캔디와 다르면
        if board[i-1][col] != board[i][col]:
            maxCandy = max(maxCandy, seq)
            seq = 1
        else:
            seq += 1
    maxCandy = max(maxCandy, seq)
    return maxCandy



# 입력 처리부분
N = int(input())
board = [list(sys.stdin.readline().rstrip()) for i in range(N)]

maxCandy = 0

# 전체 블럭들 순회
for i in range(N):
    for j in range(N):
        #교환하지 않는 경우
        if i == j:
            maxCandy = max(checkHorizon(i), maxCandy)
            maxCandy = max(checkVertical(j), maxCandy)

        # 현재 블럭 기준 우하
        # 오른쪽과 교환
        if j+1 < N:
            # 같으면 바꿔봐야 결과 안달라짐 => 넘긴다
            if board[i][j+1] == board[i][j]:
                continue
            # 캔디 바꾸고 세로 가로 검사하면서 최대값 갱신후 다시 원상 복구
            swap(i, j, i, j+1)
            maxCandy = max(checkHorizon(i), maxCandy)
            maxCandy = max(checkVertical(j), maxCandy)
            maxCandy = max(checkVertical(j+1), maxCandy)
            swap(i, j, i, j+1)
        # 아래와 교환
        if i+1 < N:
            # 같으면 안바꿈
            if board[i+1][j] == board[i][j]:
                continue
            # 캔디 바꾸고 세로 가로 검사하면서 최대값 갱신후 다시 원상 복구
            swap(i, j, i+1, j)
            maxCandy = max(checkHorizon(i), maxCandy)
            maxCandy = max(checkHorizon(i+1), maxCandy)
            maxCandy = max(checkVertical(j), maxCandy)
            swap(i, j, i+1, j)

print(maxCandy)
