/**
* 메모리: 47172 KB, 시간: 480 ms
* 2022.02.14
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        public int from, to, cost;
        public Node(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    // 부모 노드 찾기
    public static int find_set(int a){
        if(a == parent[a])  return a;
        else    return parent[a] = find_set(parent[a]);
    }

    //union
    public static void union(int a, int b){
        int aroot = find_set(a);
        int broot = find_set(b);
        parent[broot] = aroot;
    }

    static int V, E;    // 정점 갯수, 간선 갯수
    static PriorityQueue<Node> pq;
    static int[] parent;    // 부모 노드 저장
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 간선 저장할 우선순위 큐
        pq = new PriorityQueue<Node>();
        for(int i=0; i<E; i++){
            st = new StringTokenizer(in.readLine());
            // 각 정점별 간선, 가중치를 노드로 저장해 연결리스트 만들기
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Node(from, to, cost));
        }
        // parent 초기화
        parent = new int[V+1];
        for(int i=1; i<=V; i++)
            parent[i] = i;

        System.out.println(kruskal());
    }

    public static int kruskal(){
        int result = 0, cnt = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(find_set(node.from) != find_set(node.to)){
                cnt++;
                result += node.cost;
                union(node.from, node.to);
            }
            if(cnt == E-1)  break;
        }
        return result;
    }
}