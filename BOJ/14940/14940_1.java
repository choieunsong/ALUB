/**
* 메모리: 82904 KB, 시간: 684 ms
* 2022.01.13
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] map, dist;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        dist = new int[R][C];

        int destr = 0, destc = 0;
        for(int r=0; r<R; r++){
            st = new StringTokenizer(in.readLine());
            for(int c=0; c<C; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == 2){
                    destr = r;
                    destc = c;
                }
            }
        }

        bfs(destr, destc);
        StringBuffer sb = new StringBuffer();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(dist[r][c] == 0 && map[r][c] == 1) sb.append("-1 ");
                else sb.append(dist[r][c]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<int[]>();
        boolean[][] visited = new boolean[R][C];
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || map[nr][nc] == 0)   continue;
                q.offer(new int[]{nr,nc});
                dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                visited[nr][nc] = true;
            }
        }
    }
}