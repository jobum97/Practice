# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def makeList(N):
    List = list()
    for i in range(1,N+1):
        List.append(i)

    return List


if __name__ == '__main__':

    #입력 처리 부분
    input = input().split()
    print(input)
    N = int(input[0])
    K = int(input[1])

    # 리스트
    List = makeList(N)
    answerList = list()


    index = 0
    for i in range(1, N+1):
        index = (index+(K-1)) % len(List)
        #print(List,index,List[index])
        answerList.append(List.pop(index))

    #출력 형식 지키기
    answer = "<"
    answer=answer+str(answerList[0])
    for i in range(1, len(answerList)):
        answer+=", "+str(answerList[i])
    answer += ">"
    print(answer)









