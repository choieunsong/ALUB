/**
* 메모리: 23064 KB, 시간: 136 ms
* 2021.12.01
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] num = new int[M];
        int[] arr = new int[N];
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        sb = new StringBuilder();

        backtracking(N, M, 0,0, arr, num);
        System.out.println(sb.toString());
    }
    public static void backtracking( int N, int M,  int index, int cnt, int[] arr, int[] num){
        if(cnt == M){
            for(int i=0; i<M; i++)
                sb.append(num[i]+" ");
            sb.append("\n");
            return;
        }
        for(int i=index; i<N; i++){
//            if((flag & (1 << i)) != 0) continue;
            num[cnt] = arr[i];
            backtracking(N,M, i,cnt+1, arr, num);
        }
    }
}