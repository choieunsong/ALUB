/**
* 메모리: 88208 KB, 시간: 556 ms
* 2022.01.14
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][][] visited;
    static int[] hr = {-2,-2,-1,-1,1,1,2,2};
    static int[] hc = {-1,1,-2,2,-2,2,-1,1};
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int K, R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C][K+1]; //(r,c)칸에 이미 k번 말로 이동한 적이 있는지 없는지 

        for(int i=0; i<R; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0; j<C; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        Queue<int[]> q = new LinkedList<int[]>();   //r,c,K,dist
        q.offer(new int[]{0,0,0,0});
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int k = q.peek()[2];
            int dist = q.peek()[3];
            q.poll();

            if(r == R-1 && c==C-1){
                return dist;
            }
            // 상하좌우로 간 경우
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 1 || visited[nr][nc][k])  continue;
                visited[nr][nc][k] = true;
                q.offer(new int[]{nr, nc, k, dist+1});
            }
            if(k < K) {
                //말로 갈 경우
                for (int d = 0; d < 8; d++) {
                    int nr = r + hr[d];
                    int nc = c + hc[d];
                    if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 1 || visited[nr][nc][k+1])  continue;
                    visited[nr][nc][k+1] = true;
                    q.offer(new int[]{nr,nc,k+1,dist+1});
                }
            }
        }
        return -1;
    }
}