from collections import deque
import sys
read = sys.stdin.readline

def dfs(x, y, rain):
  dx = [1, -1, 0, 0]
  dy = [0, 0, -1, 1]

  q= deque()
  q.append([x, y])
  visited[x][y] = 1

  while q:
    a, b = q.popleft()
    for i in range(4):
      nx = a + dx[i]
      ny = b + dy[i]
      if 0 <= nx < n and 0 <= ny < n and field[nx][ny] > rain and visited[nx][ny] == 0:
        visited[nx][ny] = 1
        q.append([nx, ny])

n = int(read())
field = []

max_list = []

max_num = 0
for _ in range(n):
  field.append(list(map(int, read().split())))

for i in field:
  for j in i:
    if max_num < j:
      max_num = j

for k in range(max_num + 1):
  visited = [[0] * n for _ in range(n)]
  count = 0
  for i in range(n):
    for j in range(n):
      if field[i][j] > k and visited[i][j] == 0: 
        dfs(i, j, k)
        count += 1
  max_list.append(count)

print(max(max_list))