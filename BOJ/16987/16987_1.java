/**
* 메모리: 15284 KB, 시간: 232 ms
* 2021.12.04
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, max;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 내구도
            arr[i][1] = Integer.parseInt(st.nextToken()); // 무게
        }

        max = 0;
        backtracking(0);
        System.out.println(max);
    }
    public static void backtracking(int idx){
        if(idx == N){
            int cnt = 0;
            for(int i=0; i<N; i++){
                if(arr[i][0] <= 0) cnt++;
            }
            max = Math.max(max, cnt);
            return;
        }
        boolean flag = false;
        if(arr[idx][0] <= 0){
            backtracking(idx+1);
        }else {
            for (int i = 0; i < N; i++) {
                if (idx == i) continue;
                if (arr[i][0] <= 0) continue;
                flag = true;
                arr[idx][0] -= arr[i][1];
                arr[i][0] -= arr[idx][1];
                backtracking(idx+1);
                arr[idx][0] += arr[i][1];
                arr[i][0] += arr[idx][1];
            }
            if(!flag)   backtracking(idx+1);
        }
    }
}