/**
* 메모리: 139568 KB, 시간: 560 ms
* 2022.02.14
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        public int to, cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0; j<N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(prim());
    }
    public static long prim(){
        long result = 0;
        int cnt = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        boolean[] visited = new boolean[N];
        int[] minEdge = new int[N];
        Arrays.fill(minEdge, Integer.MAX_VALUE);

        pq.offer(new Node(0, 0));
        minEdge[0] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(visited[node.to])    continue;

            result += node.cost;
            visited[node.to] = true;
            if(++cnt == N)  break;

            for(int i=0; i<N; i++){
                if(!visited[i] && map[node.to][i] < minEdge[i]){
                    minEdge[i] = map[node.to][i];
                    pq.offer(new Node(i, map[node.to][i]));
                }
            }
        }

        return result;
    }
}