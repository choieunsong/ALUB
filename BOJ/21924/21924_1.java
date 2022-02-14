/**
* 메모리: 225256 KB, 시간: 1172 ms
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
            return this.cost - o.cost;
        }
    }
    static int V, E;    // 정점 갯수, 간선 갯수
    static LinkedList<Node> list[];   // 정점 연결하는 연결리스트
    static long total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new LinkedList[V+1];
        for(int i=1; i<=V; i++)
            list[i] = new LinkedList<>();

        for(int i=0; i<E; i++){
            st = new StringTokenizer(in.readLine());
            // 각 정점별 간선, 가중치를 노드로 저장해 연결리스트 만들기
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, cost));
            list[to].add(new Node(from, cost));
            total += cost;
        }
        System.out.println(prim());
    }
    public static long prim(){
        long result = 0;
        int cnt = 0;

        // 간선 가중치가 작은 순대로 우선순위큐에 저장
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];   // 정점이 mst에 속해있는지 표시
        int[] minEdge = new int[V+1];       // 정점별 최소값 저장
        Arrays.fill(minEdge, Integer.MAX_VALUE);    // 정점을 무한대값으로 초기화

        pq.offer(new Node(1, 0));   // 정점 1부터 출발
        minEdge[1] = 0;

        while(!pq.isEmpty()){
            Node minNode = pq.poll();

            if(visited[minNode.to]) continue;

            visited[minNode.to] = true;
            result += minNode.cost;
            if(++cnt == V)  break;

            for(Node node : list[minNode.to]){
                if(!visited[node.to] && node.cost < minEdge[node.to]){
                    minEdge[node.to] = node.cost;
                    pq.offer(new Node(node.to, node.cost));
                }
            }
        }

        for(int i=1; i<=V; i++){
            if(minEdge[i] == Integer.MAX_VALUE)
                return -1;
        }
        return total - result;
    }
}