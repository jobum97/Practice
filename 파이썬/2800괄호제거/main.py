import copy
import math

charList = list(input())

stack = list()
brackets = []

# 스택 활용해서 ( , ) index 셋 추출
for i in range(len(charList)):
    if charList[i] == '(':
        stack.append(i)
    elif charList[i] == ')':
        brackets.append([stack.pop(), i])


# 해당 괄호 세트 빈칸으로 만들어 제거
def eraseBrackets(index, List):
    temp = List
    temp[brackets[index][0]] = ""
    temp[brackets[index][1]] = ""


answers = []

# 2^N-1 경우 (변화 없는 처음 케이스 제외, N 은 괄호 셋 개수)
for case in range(1, 2 ** len(brackets)):
    checkBit = 1
    # 문자 배열 깊은 복사해오기
    result = copy.deepcopy(charList)

    # 비트 마스크
    # N번 만큼 반복
    for i in range(len(brackets)):
        # 체크 비트와 case 비트의 and 연산이 0보다 크다면 그 요소 선택한 것
        # 고로 제거
        if checkBit & case > 0:
            eraseBrackets(i, result)
        # 다음을 위해 비트 한칸 이동
        checkBit = checkBit << 1
    # 정답 추가
    if not "".join(result) in answers:
        answers.append("".join(result))

answers.sort()
answer = ""
for element in answers:
    answer += element + "\n"

print(answer, end='')
