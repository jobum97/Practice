import sys

N = int(input())
budgets = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
budgets.sort()

def BudgetSum(limit):
    Sum = 0
    for budget in budgets:
        if budget <= limit:
            Sum += budget
        else:
            Sum += limit

    return Sum


i = 0
j = budgets[len(budgets) - 1]

while i <= j:
    pivot = (i + j) // 2
    cur = BudgetSum(pivot)
    print(i,pivot,j)
    #
    if cur <= M:
        i = pivot + 1
    else:
        j = pivot - 1


print(j)
