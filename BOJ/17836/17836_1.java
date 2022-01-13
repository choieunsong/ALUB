/**
* 메모리: 15720 KB, 시간: 148 ms
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
    static int R, C, T;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] map;

    static class Point{
        public int r, c, time;
        public boolean isGram;
        public Point(int r, int c, int time, boolean isGram){
            this.r = r;
            this.c = c;
            this.time = time;
            this.isGram = isGram;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(in.readLine());
            for(int c=0; c<C; c++)
                map[r][c] = Integer.parseInt(st.nextToken());
        }
        int ans = bfs();
        if(ans == Integer.MAX_VALUE) System.out.println("Fail");
        else System.out.println(ans);
    }
    public static int bfs(){
        int ret = Integer.MAX_VALUE;
        Queue<Point> q = new LinkedList<Point>();
        boolean[][][] visited = new boolean[R][C][2];
        q.offer(new Point(0, 0, 0, false));
        visited[0][0][0] = true;    // [][][0]: 그람 없는상태, [][][1]: 그람 있는 상태

        while(!q.isEmpty()){
            Point cur = q.poll();
            if(cur.r == R-1 && cur.c == C-1 && cur.time <= T){
                ret = Math.min(ret, cur.time);
                continue;
            }
            for(int d=0; d<4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if(0 > nr || nr >= R || 0 > nc || nc >= C) continue;
                // 그럼이 있고 벽이 있음
                if(cur.isGram && map[nr][nc] == 1 && !visited[nr][nc][1]) {
                    visited[nr][nc][1] = true;
                    q.offer(new Point(nr, nc, cur.time+1, cur.isGram));
                }
                // 그람 있고 벽 없음
                if(cur.isGram && map[nr][nc] == 0 && !visited[nr][nc][1]){
                    visited[nr][nc][1] = true;
                    q.offer(new Point(nr, nc, cur.time+1, cur.isGram));
                }
                // 그람 없고 벽 없음
                if(!cur.isGram && map[nr][nc] == 0 && !visited[nr][nc][0]){
                    visited[nr][nc][0] = true;
                    q.offer(new Point(nr, nc, cur.time+1, cur.isGram));
                }
                // 다음 칸이 그람
                if(map[nr][nc] == 2 && !visited[nr][nc][0]){
                    visited[nr][nc][0] = true;
                    q.offer(new Point(nr, nc, cur.time+1, true));
                }
            }
        }
        return ret;
    }
}