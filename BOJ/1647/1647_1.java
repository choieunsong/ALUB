/**
* 메모리: 324424 KB, 시간: 1380 ms
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
        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    public static int find_parent(int a){
        if(a == parent[a])  return a;
        else    return parent[a] = find_parent(parent[a]);
    }

    public static void union(int a, int b){
        int aroot = find_parent(a);
        int broot = find_parent(b);
        parent[broot] = aroot;
    }

    static int[] parent;
    static int V, E;
    static PriorityQueue<Node> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for(int i=1; i<=V; i++)
            parent[i] = i;

        pq = new PriorityQueue<>();
        for(int i=0; i<E; i++){
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Node(from, to, cost));
        }
        System.out.println(kruskal());
    }
    public static int kruskal(){
        int result = 0, cnt = 0, max = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(find_parent(node.from) == find_parent(node.to))  continue;

            max = Math.max(max, node.cost);
            result += node.cost;
            union(node.from, node.to);
            if(++cnt == E) break;
        }
        return result - max;
    }
}