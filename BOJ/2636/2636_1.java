/**
* 메모리: 13620 KB, 시간: 116 ms
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
    static int[][] map;
    static int days = 0;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cheese = bfs();
        System.out.println(days);
        System.out.println(cheese);
    }
    public static void makeOutside(){
        Queue<int[]> q = new LinkedList<int[]>();
        boolean[][] visited = new boolean[R][C];
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        map[0][0] = -1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nr][nc] && map[nr][nc] != 1){
                    q.offer(new int[]{nr,nc});
                    visited[nr][nc] = true;
                    map[nr][nc] = -1;
                }
            }
        }
    }
    public static int bfs(){
        int ret = countCheese();
        while(true){
            // make outside
            makeOutside();
            days++;
            for(int r=0; r<R; r++){
                for(int c=0; c<C; c++){
                    if(map[r][c] == 1){
                        boolean melt = false;
                        for(int d=0; d<4; d++){
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if(0 <= nr && nr < R && 0 <= nc && nc < C && map[nr][nc] == -1){
                                  melt = true;
                                  break;
                            }
                        }
                        if(melt){
                            map[r][c] = -2;
                        }
                    }
                }
            }
            // if left cheese is 0, break
            int cheese = countCheese();
            if(cheese == 0) break;
            ret = cheese;
        }
        return ret;
    }
    public static int countCheese(){
        // count left cheese
        int cheese = 0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(map[r][c] == 1)   cheese++;
            }
        }
        return cheese;
    }
}
/*
5 5
0 0 0 0 0
0 1 1 0 0
0 1 0 1 0
0 1 1 1 0
0 0 0 0 0
 */