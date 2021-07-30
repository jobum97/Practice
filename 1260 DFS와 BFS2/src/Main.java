import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[vertex+1];
        
        //arraylist를 담는 배열을 만든다. 각각 arraylist에 연결된 노드의 정보가 들어간다.
        ArrayList<Integer>[] adjlist = new ArrayList[vertex+1];
        //초기화를 해서 생성을 하지 않으면 오류가 생긴다!
        for(int i=0; i<adjlist.length; i++) {
            adjlist[i] = new ArrayList<Integer>();
        }
        
        //연결리스트에 각 노드를 추가하는 과정
        for(int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            
            adjlist[a1].add(a2);
            adjlist[a2].add(a1);
        }
        
        //자식이 여러개라면 노드 번호가 작은 것 먼저 방문하므로 오름차순으로 정렬을 해줬다.
        for(int i=0; i<adjlist.length; i++) {
            Collections.sort(adjlist[i]);
        }
        
        dfs(adjlist, visited, start);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(adjlist, visited, start);
    }
    
    public static void dfs(ArrayList<Integer>[] adjlist, boolean[] visited, int v) {
        visited[v] = true;
        System.out.print(v + " ");
        
        for(int e : adjlist[v]) {
            if(!visited[e]) {
                dfs(adjlist, visited, e);
            }
        }
    }
    
    public static void bfs(ArrayList<Integer>[] adjlist, boolean[] visited, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        
        while(!q.isEmpty()) {
            v = q.poll();
            System.out.print(v + " ");
            
            for(int e : adjlist[v]) {
                if(!visited[e]) {
                    q.add(e);
                    visited[e] = true;
                }
            }
        }
    }
}