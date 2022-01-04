import sys
#입력부
N = int(input())
roads = list(map(int,sys.stdin.readline().rstrip().split()))
prices = list(map(int,sys.stdin.readline().rstrip().split()))

#가격 범위 1~1000000000
minPrice = 1000000001 #초과값 줌
result = 0

#길의 개수 만큼 반복
for i in range(N-1):
    minPrice=min(minPrice,prices[i]) #지금까지 중 최소 가격 갱신
    result+= minPrice * roads[i] #결과에 더해나감 최소 가격 * 도로

print(result)