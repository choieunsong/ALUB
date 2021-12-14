/**
* 메모리: 12332 KB, 시간: 88 ms
* 2021.12.14
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for(int i=0; i<R; i++){
            char[] ch = in.readLine().toCharArray();
            for(int j=0; j<C; j++)
                map[i][j] = ch[j] - '0';
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        Queue <int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{0,0});
        int[][] visited = new int[R][C];
        visited[0][0] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int cnt = visited[cur[0]][cur[1]];
            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(0 <= nr && nr < R && 0 <= nc && nc < C && map[nr][nc] == 1 && visited[nr][nc] == 0){
                    visited[nr][nc] = cnt+1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return visited[R-1][C-1];
    }
}