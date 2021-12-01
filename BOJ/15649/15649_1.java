/**
* 메모리: 93064 KB, 시간: 1416 ms
* 2021.12.01
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, num;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        num = new int[M];
        for(int i=0; i<N; i++)
            arr[i] = i+1;

        backtracking(0, 0);
    }
    public static void backtracking(int cnt, int flag){
        if(cnt == M){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<M; i++)
                sb.append(num[i]+" ");
            System.out.println(sb.toString());
            return;
        }
        for(int i=0; i<N; i++){
            if((flag & (1 << i)) != 0) continue;
            num[cnt] = i+1;
            backtracking(cnt+1, flag | (1<<i));
        }
    }
}