/**
* 메모리: 13008 KB, 시간: 112 ms
* 2022.01.13
* by Alub
*/
import java.io.IOException;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, max=0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=1; i<=N; i++)
            arr[i] = sc.nextInt();

        for(int i=1; i<=N; i++){
            visited = new boolean[N+1];
            if(dfs(i, i) == 1)
                ans.add(i);
        }
        System.out.println(ans.size());
        for(int i:ans)
            System.out.println(i);
    }
    public static int dfs(int target, int num) {
        if (!visited[num]) {
            visited[num] = true;
            return dfs(target, arr[num]);
        }
        if (target == num) return 1;
        return 0;
    }
}