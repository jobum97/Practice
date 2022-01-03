import sys

# 표준 입력을 파일로 설정하기 -> input.txt를 읽어들여옴
#stdin = open("input.txt", "r")

def isValid(line):
    List = list(line)
    stack = list()

    for component in List:
        if(component == '('):
            stack.append(component)
        elif(component==')'):
            if(len(stack) == 0):
                return "NO"
            stack.pop()
    if(len(stack) > 0):
        return "NO"

    return "YES"

N = int(input())
output = ""
List =[input() for _ in range(N)]
for line in List:
    output += isValid(line) + "\n"

print(output)



