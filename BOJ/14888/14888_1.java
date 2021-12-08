/**
* 메모리: 12808 KB, 시간: 524 ms
* 2021.12.08
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, tmp;
    static int[] op;
    static int min, max;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        tmp = new int[N-1];
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        op = new int[N-1];
        st = new StringTokenizer(in.readLine());
        int idx= 0;
        for(int i=0; i<4; i++){
            int cnt = Integer.parseInt(st.nextToken());
            for(int j=0; j<cnt; j++)
                op[idx++] = i;
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        backtracking(0,0);
        System.out.println(max);
        System.out.println(min);
    }
    public static void backtracking(int idx, int flag){
        if(idx == N-1){
            int sum = arr[0];
            for(int i=1; i<N; i++){
                switch(tmp[i-1]){
                    case 0: sum += arr[i]; break;
                    case 1: sum -= arr[i]; break;
                    case 2: sum *= arr[i]; break;
                    case 3: sum /= arr[i]; break;
                }
            }
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        // operator의 순서를 바꿈
        for(int i=0; i<N-1; i++){
            if((flag & (1<<i)) != 0) continue;
            tmp[idx] = op[i];
            backtracking(idx+1, flag | 1 << i);
        }
    }
}