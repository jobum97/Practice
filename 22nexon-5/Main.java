import java.util.*;

public class Main {
    public static void main(String[] args) {
        
    }


    // x, y 노드 들리면서 학교가는 최단 경로는?

    public static int minCostPath(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight, int x, int y) {
        // 언제나 출발 1 도착점 gNodes

        ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i <= gNodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < gFrom.size(); i++) {
            adjList.get(gFrom.get(i)).add(new Edge(gTo.get(i), gWeight.get(i)));
            adjList.get(gTo.get(i)).add(new Edge(gFrom.get(i), gWeight.get(i)));
        }

        System.out.println(gNodes + " " + x + " " + y);
        for (int i = 0; i < gFrom.size(); i++) {
            System.out.println(gFrom.get(i) + " " + gTo.get(i) + " " + gWeight.get(i));
        }

        int distXY = getShortestPathCost(x, y, adjList);
        int X1 = getShortestPathCost(1, x, adjList);
        int Y1 = getShortestPathCost(1, y, adjList);
        int Xg = getShortestPathCost(gNodes, x, adjList);
        int Yg = getShortestPathCost(gNodes, y, adjList);

        System.out.println(distXY + " " + X1 + " " + Y1 + " " + Xg + " " + Yg);
        return Math.min(X1 + Yg, Y1 + Xg) + distXY;
    }

    public static int getShortestPathCost(int start, int end, ArrayList<ArrayList<Edge>> adjList) {

        PriorityQueue<Edge> pq = new PriorityQueue();

        int[] dis = new int[adjList.size()];
        for (int i = 1; i < dis.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }

        pq.add(new Edge(start, 0));
        dis[start] = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            for (int i = 0; i < adjList.get(cur.nextNode).size(); i++) {
                int nextWeight = cur.weight + adjList.get(cur.nextNode).get(i).weight;
                int nextNode = adjList.get(cur.nextNode).get(i).nextNode;
                if (dis[nextNode] > nextWeight) {
                    pq.add(new Edge(nextNode, nextWeight));
                    dis[nextNode] = nextWeight;
                }
            }
        }
        return dis[end];
    }

    public static class Edge implements Comparable<Edge>{
        int nextNode;
        int weight;

        public Edge(int nextNode, int weight) {
            this.nextNode = nextNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

}


