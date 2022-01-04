import sys

#입력 처리
N = int(input())
energyDrinks = list(map(int, sys.stdin.readline().split()))

energyDrinks.sort() #오름차순으로 정렬

#제일 큰 놈한테 다 섞는 것이 베스트
#괜히 작은 애들끼리 합치고 합치면 2번 이상 쪼개짐
result = 0

for i in range(N-1):
    result+=energyDrinks[i]

print(result/2 + energyDrinks[N-1])



