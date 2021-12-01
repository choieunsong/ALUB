/**
* 메모리: 315812 KB, 시간: 632 ms
* 2021.12.01
* by Alub
*/
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] num = new int[M];
        sb = new StringBuilder();

        backtracking(N, M,0, num);
        System.out.println(sb.toString());
    }
    public static void backtracking( int N, int M, int cnt, int[] num){
        if(cnt == M){
            for(int i=0; i<M; i++)
                sb.append(num[i]+" ");
            sb.append("\n");
            return;
        }
        for(int i=0; i<N; i++){
            num[cnt] = i+1;
            backtracking(N,M,cnt+1, num);
        }
    }
}