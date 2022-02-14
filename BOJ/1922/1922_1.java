/**
* 메모리: 52024 KB, 시간: 424 ms
* 2022.02.14
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        public int to, cost;
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Node o){
            return  this.cost - o.cost;
        }
    }

    static int N, M;
    static LinkedList<Node> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());

        list = new LinkedList[N+1];
        for(int i=1; i<=N; i++)
            list[i] = new LinkedList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, cost));
            list[to].add(new Node(from, cost));
        }
        System.out.println(prim());
    }

    public static long prim(){
        long result = 0;
        int cnt = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        boolean[] visited = new boolean[N+1];
        int[] minEdge = new int[N+1];
        Arrays.fill(minEdge, Integer.MAX_VALUE);

        pq.offer(new Node(1, 0));
        minEdge[1] = 0;

        while(!pq.isEmpty()){
            Node minNode = pq.poll();
            if(visited[minNode.to])    continue;

            visited[minNode.to] = true;
            result += minNode.cost;
            //if(++cnt == M)  break;

            for(Node node : list[minNode.to]){
                if(!visited[node.to] && node.cost < minEdge[node.to]){
                    minEdge[node.to] = node.cost;
                    pq.offer(new Node(node.to, node.cost));
                }
            }
        }

        return result;
    }
}