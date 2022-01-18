import sys

N, M = map(int, input().split())

times = [int(sys.stdin.readline()) for _ in range(N)]

print(N, M)
print(times)

def passPeople(totalTime):
    people = 0
    for time in times:
        people += totalTime // time

    return people

i = 0
j = M * max(times)

while i < j:
    pivot = (i + j) // 2

    cur_cnt = passPeople(pivot)
    #print(i, pivot, j, cur_cnt)
    if  M <= cur_cnt:
        j = pivot
    else:
        i = pivot+1

print(i)
