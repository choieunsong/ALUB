/**
* 메모리: 81124 KB, 시간: 688 ms
* 2022.01.13
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> pools = new LinkedList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            pools.offer(x);
            set.add(x);
        }

        Queue<int[]> q = new LinkedList<>();
        for(Integer x : pools){
            if(!set.contains(x-1)){
                set.add(x-1);
                q.offer(new int[]{x-1, x});    //city, pool
            }
            if(!set.contains(x+1)){
                set.add(x+1);
                q.offer(new int[]{x+1, x});
            }
        }
        long ans = 0;
        while(K-- > 0){
            int city = q.peek()[0];
            int pool = q.peek()[1];
            q.poll();

            ans += (long)Math.abs(city - pool);
            if(!set.contains(city - 1)){
                set.add(city-1);
                q.offer(new int[]{city-1, pool});
            }
            if(!set.contains(city+1)){
                set.add(city+1);
                q.offer(new int[]{city+1, pool});
            }
        }
        System.out.println(ans);
    }
}