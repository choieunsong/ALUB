/**
* 메모리: 11908 KB, 시간: 108 ms
* 2021.11.23
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int dp[] = new int[41];
    static void find(){
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= 40; i++)
            dp[i] = dp[i-1] + dp[i-2];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        find();
        int T = Integer.parseInt(in.readLine());
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(in.readLine());
            if(n == 0) System.out.printf("%d %d\n", 1, 0);
            else System.out.printf("%d %d\n", dp[n-1], dp[n]);
        }
    }
}