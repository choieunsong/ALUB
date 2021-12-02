/**
* 메모리: 48940 KB, 시간: 132 ms
* 2021.12.02
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

        backtracking(N, M,0,0, arr, num);
        System.out.println(sb.toString());
    }
    public static void backtracking( int N, int M,int index, int cnt,  int[] arr, int[] num){
        if(cnt == M){
            for(int i=0; i<M; i++)
                sb.append(num[i] + " ");
            sb.append("\n");
            return;
        }
        boolean[] used = new boolean[10001];
        for(int i=index; i<N; i++){
            if(used[arr[i]] ) continue;
            used[arr[i]] = true;
            num[cnt] = arr[i];
            backtracking(N,M,i,cnt+1, arr, num);
        }
    }
}