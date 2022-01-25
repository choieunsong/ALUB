/**
* 메모리: 127428 KB, 시간: 1056 ms
* 2022.01.25
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] map;
    static int R, C, H, W, Sr, Sc, Fr, Fc;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for(int i=0; i<R; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(in.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Sr = Integer.parseInt(st.nextToken())-1;
        Sc = Integer.parseInt(st.nextToken())-1;
        Fr = Integer.parseInt(st.nextToken())-1;
        Fc = Integer.parseInt(st.nextToken())-1;

        System.out.println(bfs());
    }
    //bfs 탐색
    public static int bfs(){
        Queue<int[]> q = new LinkedList<int[]>();   //r,c,dist
        boolean[][] visited = new boolean[R][C];
        q.offer(new int[]{Sr,Sc,0});
        visited[Sr][Sc] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == Fr && cur[1] == Fc){
                return cur[2];
            }
            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(0 > nr || nr >= R || 0 > nc || nc >= C || visited[nr][nc] || map[nr][nc] == 1)   continue;
                if(isValid(nr, nc, d)){
                    q.offer(new int[]{nr,nc, cur[2] + 1});
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }
    // 방향별 valid check
    public static boolean isValid(int r, int c, int dir){
        // 상
        if(dir == 0){
            for(int i=c; i<W+c; i++){
                if(map[r][i] == 1)  return false;
            }
        } else if(dir == 1){
            //하
            int nr = r + H - 1;
            if(nr >= R)  return false;
            for(int i=c; i<W+c; i++){
                if(map[nr][i] == 1)  return false;
            }
        } else if(dir == 2){
            //좌
            for(int i=r; i<H+r; i++){
                if(map[i][c] == 1) return false;
            }
        } else{
            // 우
            int nc = c + W - 1;
            if(nc >= C) return false;
            for(int i=r; i<H+r; i++){
                if(map[i][nc] == 1) return false;
            }
        }
        return true;
    }
}