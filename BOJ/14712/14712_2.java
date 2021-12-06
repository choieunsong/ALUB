/**
* 메모리: 14816 KB, 시간: 404 ms
* 2021.12.06
* by Alub
*/
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int N, M, ans = 0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        backtracking(0);

        System.out.println(ans);
    }
    public static void backtracking(int cnt){
        if(cnt == M * N){
            ans++;
            return;
        }
        int r = cnt/M ;
        int c = cnt%M ;

        if(0 <= r-1 && 0 <= c-1 && map[r-1][c] == 1 && map[r][c-1] == 1 && map[r-1][c-1] == 1){
            backtracking(cnt+1);
        }else{
            backtracking(cnt+1);
            map[r][c] = 1;
            backtracking(cnt+1);
            map[r][c] = 0;
        }

    }
}