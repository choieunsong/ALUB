/**
* 메모리: 11600 KB, 시간: 80 ms
* 2022.01.14
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N = 8;
    static char[][] map = new char[N][N];
    static int[] dr = {-1,-1,-1,0,0,0,1,1,1};
    static int[] dc = {-1,0,1,-1,0,1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<N; i++){
            char[] ch = in.readLine().toCharArray();
            for(int j=0; j<N; j++)
                map[i][j] = ch[j];
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        boolean[][][] visited = new boolean[9][N][N];
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{N-1,0, 0});   // r,c,time

        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int time = q.peek()[2];
            q.poll();
            
            if(r == 0 && c == N-1)  return 1;   //목적지에 도달했을 때

            for(int d = 0; d < 9; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                int nt = Math.min(time + 1, 8);

                if(nr < 0 || nr >= N || nc < 0 || nc >= N)  continue;
                // 벽이라서 못갈 때
                if(nr - time >= 0 && map[nr - time][nc] == '#') continue;
                // 내려올 벽이 닿았을 때
                if(nr - nt >= 0 && map[nr - nt][nc] == '#') continue;

                if(!visited[nt][nr][nc]){
                    visited[nt][nr][nc] = true;
                    q.offer(new int[]{nr, nc, nt});
                }
            }
        }
        return 0;
    }

}