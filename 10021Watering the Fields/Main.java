import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;


public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();

    static String src="10 18\n" +
            "6 17\n" +
            "3 20\n" +
            "12 14\n" +
            "10 7\n" +
            "20 10\n" +
            "18 18\n" +
            "11 13\n" +
            "13 6\n" +
            "4 17\n" +
            "3 7";
    static int N, C;
    static PriorityQueue<Link> links;
    static int parent[];
    public static void main(String args[]) throws IOException {
        //input=new BufferedReader(new InputStreamReader(System.in));
        input=new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());

        Coord coordList[] = new Coord[N];
        links = new PriorityQueue<>();
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        // 0 <= x, y <= 1000
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            coordList[i] = new Coord(x, y);
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int dist = getEuclideanDist(coordList[i].x, coordList[i].y, coordList[j].x, coordList[j].y);
                if (dist >= C) {
                    links.add(new Link(i, j, dist));
                }
            }
        }

        // 주어진 위치들(x,y)을 잇는 최소거리
        int answer = 0;
        int count = 0;
        while(!links.isEmpty()){
            Link link = links.poll();
            if (count == N - 1) {
                break;
            }
            if (findParent(link.s) != findParent(link.e)) {
                union(link.s, link.e);
                answer += link.dist;
                count++;
            }
        }

        if (count != N-1) {
            answer = -1;
        }

        System.out.print(answer);
    }

    public static void union(int x, int y) {
        int pX = findParent(x);
        int pY = findParent(y);

        if (pX > pY) {
            parent[pX] = pY;
        }else{
            parent[pY] = pX;
        }
    }

    public static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        return findParent(parent[x]);
    }

    public static int getEuclideanDist(int x1, int y1, int x2, int y2) {
        return ((int) Math.pow(x2 - x1, 2)) + ((int) Math.pow(y2 - y1, 2));
    }

    public static class Link implements Comparable<Link>{
        int s;
        int e;
        int dist;

        public Link(int s, int e, int dist) {
            this.s = s;
            this.e = e;
            this.dist = dist;
        }

        @Override
        public int compareTo(Link o) {
            return this.dist - o.dist;
        }
    }

    public static class Coord{
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

