/**
* 메모리: 11868 KB, 시간: 240 ms
* 2021.12.04
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] cost;
    static int N, min;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());

        cost = new int[N][N];
        for(int i=0; i<N; i++){
            st= new StringTokenizer(in.readLine());
            for(int j=0; j<N; j++)
                cost[i][j] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;

        for(int i=0; i<N; i++)
            backtracking(0, i, i, 0, 0);
        
        System.out.println(min);
    }

    public static void backtracking(int flag, int start, int prev, int idx, int sum){
        if(idx == N-1){
            if(cost[prev][start] == 0) return;
            min = Math.min(min, sum + cost[prev][start]);
            return;
        }
        for(int i=0; i<N; i++){
            if((flag & (1 << i)) != 0  || i == start || cost[prev][i] == 0) continue;
            backtracking(flag | (1 << i), start,  i, idx+1, sum + cost[prev][i]);
        }
    }
}