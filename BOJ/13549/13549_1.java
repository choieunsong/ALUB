/**
* 메모리: 34552 KB, 시간: 168 ms
* 2022.01.13
* by Alub
*/
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        if(N == K) System.out.println(0);
        else System.out.println(bfs());
    }
    public static int bfs(){
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{N, 0});
        boolean[] visited = new boolean[100001];

        while(!q.isEmpty()){
            int cur[] = q.poll();
            visited[cur[0]] = true;

            if(cur[0] == K){
                return cur[1];
            }
            if(cur[0]*2 <= 100000 && !visited[cur[0]*2]) q.offer(new int[]{cur[0]*2, cur[1]});
            if(cur[0]-1 >= 0 && !visited[cur[0]-1]) q.offer(new int[]{cur[0]-1, cur[1] + 1});
            if(cur[0]+1 <= 100000 && !visited[cur[0]+1]) q.offer(new int[]{cur[0]+1, cur[1] + 1});
        }
        return 0;
    }
}