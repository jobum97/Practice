import sys

equation = list(sys.stdin.readline().rstrip())

stack = list()

# 피연산자는 순서 안바뀜 바로 사용가능
# 연산자 입력시 우선순위가 높거나 같으면 pop 그리고 자기는 push
# 괄호는 ( 는 push ) 는 ( 까지 pop

answer = ""
# 곱셈, 나눗셈 먼저 처리해야함
for element in equation:
    #print(stack)
    if (element >= 'A') & (element <= 'Z'):
        answer += element
    elif (element == '*') | (element == '/'):

        j = 0
        size = len(stack)
        i = size - 1
        while j < size:
            if (stack[i] == '*') | (stack[i] == '/'):
                answer += stack.pop(i)
            elif stack[i] == '(':
                break
            i -= 1
            j += 1
        stack.append(element)
    elif (element == '+') | (element == '-'):
        j = 0
        size = len(stack)
        i = size - 1
        while j < size:
            if (stack[i] == '+') | (stack[i] == '-') | (stack[i] == '*') | (stack[i] == '/'):
                answer += stack.pop(i)
            elif stack[i] == '(':
                break
            i -= 1
            j += 1
        stack.append(element)
    elif element == '(':
        stack.append(element)
    elif element == ')':
        while len(stack) > 0:
            cur = stack.pop()
            if cur == '(':
                break
            answer += cur

while len(stack) > 0:
    answer += stack.pop()

print(answer)
