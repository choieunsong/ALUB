/**
* 메모리: 103180 KB, 시간: 2320 ms
* 2021.12.14
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;
    static boolean[] visited;
    static LinkedList<Integer> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        visited = new boolean[N+1];
        list = new LinkedList[N+1];
        for(int i=1; i<N+1; i++) {
            list[i] = new LinkedList<Integer>();
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);

        for(int i=2; i<=N; i++)
            System.out.println(parent[i]);
    }

    public static void dfs(int cur){
        visited[cur] = true;

        for(Integer next : list[cur]){
            if(!visited[next]){
                parent[next] = cur;
                dfs(next);
            }
        }
    }
}