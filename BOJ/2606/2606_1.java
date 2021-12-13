/**
* 메모리: 11864 KB, 시간: 80 ms
* 2021.12.13
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static LinkedList<Integer> list[];
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        list = new LinkedList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<N+1; i++)
            list[i] = new LinkedList<Integer>();

        st = new StringTokenizer(in.readLine());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        System.out.println(bfs(1));
    }
    public static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int cnt = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(visited[cur]) continue;
            visited[cur] = true;
            cnt++;
            for(Integer next: list[cur]){
                q.offer(next);
            }
        }
        return cnt-1;
    }
}