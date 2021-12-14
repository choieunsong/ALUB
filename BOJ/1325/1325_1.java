/**
* 메모리: 301932 KB, 시간: 7632 ms
* 2021.12.14
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer> list[];
    static boolean[] visited;
    static int[] cnt;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        cnt = new int[N+1];
        for(int i=1;i<=N; i++)
            list[i] = new ArrayList<Integer>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);

        }
        for(int i=1; i<=N; i++){
            // visited 초기화 필수
            visited = new boolean[N+1];
            bfs(i);
        }
        for(int i=1; i<=N; i++){
            max =Math.max(cnt[i], max);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(cnt[i] == max){
                sb.append(i+" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
    public static void bfs(int cur){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(cur);
        visited[cur] = true;
        while(!q.isEmpty()){
            cur = q.poll();
            for(int next: list[cur]){
                if(!visited[next]){
                    cnt[next]++;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

    }
    public static void dfs(int cur){
        // 노드가 호출되는 수를 저장
        for(int next : list[cur]){
            if(!visited[next]){
                visited[next] = true;
                cnt[next]++;
                dfs(next);
            }
        }
    }
}