/**
* 메모리: 11964 KB, 시간: 100 ms
* 2021.12.16
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            char[] ch = in.readLine().toCharArray();
            for(int j=0; j<N; j++){
                map[i][j] = ch[j] - '0';
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int idx = 1;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(!visited[r][c] && map[r][c] == 1){
                    int ans = bfs(r, c, idx++);
                    list.add(ans);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i));
    }
    public static int bfs(int r, int c, int idx){
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{r,c});
        int cnt = 1;
        visited[r][c] = true;
        map[r][c] = idx;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc] && map[nr][nc] == 1){
                    q.offer(new int[]{nr,nc});
                    visited[nr][nc] = true;
                    cnt++;
                    map[nr][nc] = idx;
                }
            }
        }

        return cnt;
    }
}