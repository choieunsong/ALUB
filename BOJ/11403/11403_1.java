/**
* 메모리: 23776 KB, 시간: 656 ms
* 2021.12.11
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        map = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j=0;j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        floyd();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.printf("%d ",map[i][j]);
            }
            System.out.println();
        }

    }

    public static void floyd(){
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][k] != 0 && map[k][j] != 0)
                        map[i][j] = 1;
                }
            }
        }
    }
}