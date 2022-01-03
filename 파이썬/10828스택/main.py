import sys

# 표준 입력을 파일로 설정하기 -> input.txt를 읽어들여옴
#sys.stdin = open("input.txt", "r")

if __name__ == '__main__':

    N = int(sys.stdin.readline())
    List = list()
    output = ""

    for i in range(1, N+1):
        input = sys.stdin.readline().split()
        #print(input)
        if(input[0] == "push"):
            List.append(int(input[1]))
        elif(input[0] == "pop"):
            if(len(List) > 0):
                output += str(List.pop())+"\n"
            else:
                output += "-1\n"
        elif (input[0] == "size"):
            output += str(len(List)) + "\n"

        elif (input[0] == "empty"):
            if (len(List) == 0):
                output += "1\n"
            else:
                output += "0\n"
        elif (input[0] == "top"):
            if (len(List) > 0):
                output += str(List[len(List)-1]) + "\n"
            else:
                output += "-1\n"

    print(output)


