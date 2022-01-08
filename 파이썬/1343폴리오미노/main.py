data = list(input())

#print(data)

answer = ""

xSeq = 0 # 연속된 x 개수 카운팅
isValid = 1 # x 개수 홀수인 부분 발생 == 못채움 => 에러


for char in data:
    if char == 'X':
        xSeq += 1
        # x 4개 되는대로 붙이기
        if xSeq == 4:
            answer += "AAAA"
            xSeq = 0
    elif char == '.':
        # .왔을 대 x 뭉치 검사
        # 홀수 개인 경우 에러
        if xSeq % 2 == 1:
            isValid = 0
            break
        # x 개수 2개면 BB 추가
        if xSeq == 2:
            answer += "BB"
        xSeq = 0
        answer += char

# .으로 끝나지 않는 경우 마지막 X 뭉치 처리
if xSeq % 2 == 1:
    isValid = 0
elif xSeq == 4:
    answer += "AAAA"
elif xSeq == 2:
    answer += "BB"


if isValid == 1:
    print(answer)
elif isValid == 0:
    print(-1)
