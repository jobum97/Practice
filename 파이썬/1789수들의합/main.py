import math

N = int(input())

temp = int(math.sqrt(N * 2)) + 1
target = N * 2
#print(target, temp)

for i in range(temp, 0, -1):
    cur = i * (i + 1)
    #print(cur, target)
    if cur <= target:
        answer = i
        break

print(answer)