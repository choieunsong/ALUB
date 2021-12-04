/**
* 메모리: 11584 KB, 시간: 92 ms
* 2021.12.04
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S, ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        backtracking(0,  0);

        System.out.println(ans);
    }
    public static void backtracking(int cnt, int sum){
        if(cnt == N) {
            return;
        }
        if(sum + arr[cnt] == S) ans++;
        backtracking( cnt+1, sum);
        backtracking( cnt+1, sum+arr[cnt]);
    }
}