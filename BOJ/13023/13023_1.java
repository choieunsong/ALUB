/**
* 메모리: 18244 KB, 시간: 260 ms
* 2022.01.14
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static LinkedList<Integer> list[];
    // depth가 4개가 되는 tree가 있냐
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        list = new LinkedList[N];
        for(int i=0; i<N; i++)
            list[i] = new LinkedList<Integer>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=0; i<N; i++){
            dfs(i, 0);
        }
        System.out.println(0);
    }
    public static void dfs(int cur, int depth){
        visited[cur] = true;

        if(depth == 4){
            System.out.println(1);
            System.exit(0);
        }
        for(int next : list[cur]){
            if(!visited[next])
                dfs(next, depth+1);
        }
        visited[cur] = false;
    }
}