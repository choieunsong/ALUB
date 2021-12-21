/**
* 메모리: 13404 KB, 시간: 120 ms
* 2021.12.21
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[][][] dir = {
            {{-1,-1},{-1,0},{0,-1},{0,1},{1,-1},{1,0}},     //짝
            {{-1,0},{-1,1},{0,-1},{0,1},{1,0},{1,1}}    //홀
    };
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R+2][C+2];
        visited = new boolean[R+2][C+2];
        for(int i=1; i<=R; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=1; j<=C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        make_outside();
        System.out.println(bfs());
    }
    public static boolean valid(int r, int c){
        return 0 <= r && r <= R+1 && 0 <= c && c <= C+1;
    }
    // outside를 -1로 채우기
    public static void make_outside(){
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d=0; d<6; d++){
                int nr = cur[0] + dir[cur[0]%2][d][0];
                int nc = cur[1] + dir[cur[0]%2][d][1];
                if(!valid(nr, nc)) continue;
                if(map[nr][nc] == 1 || visited[nr][nc]) continue;
                q.offer(new int[]{nr,nc});
                visited[nr][nc] = true;
            }
        }
    }
    public static int bfs(){
        int ans = 0;

        for(int r=1; r<=R; r++){
            for(int c=1; c<=C; c++){
                if(map[r][c] == 0)  continue;
                for(int d=0; d<6; d++){
                    int nr = r + dir[r%2][d][0];
                    int nc = c + dir[r%2][d][1];
                    if(visited[nr][nc]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}