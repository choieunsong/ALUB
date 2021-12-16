/**
* 메모리: 121260 KB, 시간: 592 ms
* 2021.12.16
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static Queue<int[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        int oneCnt = 0, minusCnt = 0;
        q = new LinkedList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.add(new int[]{i, j});
                    oneCnt++;
                    visited[i][j] = true;
                }else if(map[i][j] == -1){
                    minusCnt++;
                }
            }
        }
        int totalCnt = N*M;
        if(totalCnt - oneCnt - minusCnt == 0){
            System.out.println(0);
        }else{
            System.out.println(bfs());
        }
    }
    public static int bfs(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            // 만약 모든 map이 전부 찼으면
            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && map[nr][nc] == 0){
                    visited[nr][nc] = true;
                    map[nr][nc] = map[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        int ret = 0;
        loop:
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    return -1;
                }else{
                    ret = Math.max(ret, map[i][j]);
                }
            }
        }
        return ret-1;
    }
}