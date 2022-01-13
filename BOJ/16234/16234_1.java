/**
* 메모리: 295356 KB, 시간: 616 ms
* 2022.01.13
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int ans = 0;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int r = 0; r < N; r++){
            st = new StringTokenizer(in.readLine());
            for(int c = 0; c < N; c++)
                map[r][c] = Integer.parseInt(st.nextToken());
        }

        find();
        System.out.println(ans);
    }
    public static void find(){
        while(true){
            int idx = 1;
            boolean flag = false;
            int[][] visited = new int[N][N];
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    // move people if not visited
                    if(visited[r][c] == 0){
                        int sum = map[r][c];
                        int cnt = 1;
                        idx++;
                        Queue<int[]> q = new LinkedList<int[]>();
                        q.offer(new int[]{r,c});
                        visited[r][c] = idx;

                        while(!q.isEmpty()){
                            int[] cur = q.poll();
                            for(int d=0; d<4; d++){
                                int nr = cur[0] + dr[d];
                                int nc = cur[1] + dc[d];
                                if(0 <= nr && nr < N && 0 <= nc && nc < N && visited[nr][nc] == 0 ){
                                    int gap = Math.abs(map[nr][nc] - map[cur[0]][cur[1]]);
                                    if(L <= gap && gap <= R){
                                        q.offer(new int[]{nr, nc});
                                        cnt++;
                                        sum += map[nr][nc];
                                        visited[nr][nc] = idx;
                                    }
                                }
                            }
                        }
                        // if union exist make flag true, increase ans
                        if(cnt > 1){
                            int avg = (int)Math.floor(sum / cnt);
                            for(int i=0; i<N; i++){
                                for(int j=0; j<N; j++){
                                    if(visited[i][j] == idx)    map[i][j] = avg;
                                }
                            }
                            flag = true;
                        }
                    }
                }
            }
            // no union return
            if(!flag) return;
            ans++;
        }
    }
}