N = int(input())

words = [input() for i in range(N)]

possibleWords = set()

answer = 0

for word in words:
    # 가능한 경우에 있으면 넘어감
    if word in possibleWords:
        continue
    # 가능한 경우에 없으면
    else:
        # 서로 다른 단어수를 올리고
        answer += 1
        # 이번단어로 가능한 경우들을 possibleWords 에 넣어준다
        temp = word
        size = len(word)
        for i in range(len(word)):
            temp = temp[size - 1: size] + temp[0:size - 1]
            possibleWords.add(temp)

print(answer)