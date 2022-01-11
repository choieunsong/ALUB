/**
* 메모리: 126004 KB, 시간: 320 ms
* 2022.01.11
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C, max = 0;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> cell;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited =  new boolean[R][C];
        cell = new ArrayList<int[]>();

        for(int i=0; i<R; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0)  cell.add(new int[]{i,j});
            }
        }
        dfs(0,0);
        System.out.println(max);
    }
    public static void dfs(int idx, int cnt){
        if(cnt == 3){
            //bfs로 바이러스 퍼트리기
            Queue<int[]> q = new LinkedList<>();
            visited = new boolean[R][C];
            for(int r=0; r<R; r++){
                for(int c=0; c<C; c++){
                    if(map[r][c] == 2){
                        q.offer(new int[]{r,c});
                        while(!q.isEmpty()){
                            int[] cur = q.poll();

                            for(int d=0; d<4; d++){
                                int nr = cur[0] + dr[d];
                                int nc = cur[1] + dc[d];
                                if(0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nr][nc] && map[nr][nc] == 0){
                                    visited[nr][nc] = true;
                                    q.offer(new int[]{nr,nc});
                                }
                            }
                        }
                    }
                }
            }
            //0 개수 cnt
            int num = 0;
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(!visited[i][j] && map[i][j] == 0)    num++;
                }
            }
            max= Math.max(max, num);
            return;
        }
        // 설치할 벽 고르기
        if(idx == cell.size())  return;
        int[] cur = cell.get(idx);
        map[cur[0]][cur[1]] = 1;
        dfs(idx+1, cnt+1);
        map[cur[0]][cur[1]] = 0;
        dfs(idx+1, cnt);
    }
}