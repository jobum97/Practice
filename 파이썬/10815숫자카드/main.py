import sys

N = int(input())
Cards = list(map(int, sys.stdin.readline().split()))
Cards.sort()
M = int(input())
checkList = list(map(int, sys.stdin.readline().split()))

# print(Cards)
# print(checkList)


def binarySearch_recursion(i, j, target):
    pivot = (i + j) // 2
    answer = False

    if (j - i == 1) & (Cards[i] != target):
        return False

    if target < Cards[pivot]:
        answer = binarySearch_recursion(i, pivot, target)
    elif target > Cards[pivot]:
        answer = binarySearch_recursion(pivot + 1, j, target)
    else:
        answer = True

    return answer

def binarySearch(target):
    i=0
    j=N
    answer = False

    while j - i != 0:
        pivot = (i + j) // 2
        #print(i, j, pivot)
        if (j - i == 1) & (Cards[i] != target):
            answer = False
            break
        if target < Cards[pivot]:
            j=pivot
        elif target > Cards[pivot]:
            i = pivot+1
        else:
            answer=True
            break
    return answer

answers = []
for i in range(len(checkList)):
    if binarySearch(checkList[i]):
        answers.append(1)
    else:
        answers.append(0)

print(' '.join(map(str,answers)))
