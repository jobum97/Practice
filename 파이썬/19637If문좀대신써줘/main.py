import sys

N, M = map(int, input().split())

dictionary = []
strength = []
for i in range(N):
    str = sys.stdin.readline().split()
    temp_power = int(str[1])
    # 중복되는 부분 제외
    if strength and strength[-1] == temp_power:
        continue
    dictionary.append(str[0])
    strength.append(temp_power)

def binarySearch(power):
    i = 0
    j = len(strength)-1

    while i <= j:
        pivot = (i+j)//2
        #print(i,pivot,j)
        if strength[pivot] < power:
            i = pivot + 1
        else:
            j = pivot - 1

    return j+1

testcases = []
for i in range(M):
     tc = int(sys.stdin.readline())
     testcases.append(tc)

for tc in testcases:
    print(dictionary[binarySearch(tc)])
