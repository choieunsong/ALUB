/**
* 메모리: 124124 KB, 시간: 680 ms
* 2021.12.16
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] map;
    static boolean[][][] visited;
    static int N, M, H;
    static Queue<int[]> q;
    static int[][] dir = {{-1,0,0}, {1,0,0}, {0,-1,0}, {0,1,0}, {0,0,-1}, {0,0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        visited = new boolean[H][N][M];
        q = new LinkedList<int[]>();
        int oneCnt = 0, minusCnt = 0;
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(in.readLine());
                for(int k=0; k<M; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1){
                        q.offer(new int[]{i, j, k});
                        visited[i][j][k] = true;
                        oneCnt++;
                    }else if(map[i][j][k] == -1){
                        minusCnt++;
                    }
                }
            }
        }

        if(N*M*H - H*(oneCnt + minusCnt) == 0){
            System.out.println(0);
        }else{
            System.out.println(bfs());
        }

    }
    public static int bfs(){
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int d=0; d<6; d++){
                int nh = cur[0] + dir[d][0];
                int nr = cur[1] + dir[d][1];
                int nc = cur[2] + dir[d][2];

                if(0 <= nh && nh < H && 0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nh][nr][nc] && map[nh][nr][nc] == 0){
                    visited[nh][nr][nc] = true;
                    q.offer(new int[]{nh, nr, nc});
                    map[nh][nr][nc] = map[cur[0]][cur[1]][cur[2]] + 1;
                }
            }
        }
        int ret = 0;
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(map[i][j][k] == 0)
                        return -1;
                    else
                        ret = Math.max(ret, map[i][j][k]);
                }
            }
        }
        return ret-1;
    }
}