/**
* 메모리: 69048 KB, 시간: 1040 ms
* 2021.12.01
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static class Circle implements Comparable<Circle>{
        public int str, end;
        public Circle(int x, int r){
            this.str = x-r;
            this.end = x+r;
        }
        public int compareTo(Circle o){
            return this.str == o.str ? this.end - o.end : this.str - o.str;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());

        Circle[] list = new Circle[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(in.readLine());
            int str = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[i] = new Circle(str, end);
        }
        Arrays.sort(list);
        // 원의 end만 비교
        Stack<Integer> stack = new Stack<Integer>();
        boolean flag = true;
        for(Circle circle : list){
            // 원의 시작부분이 비교할 원의 끝보다 크면 다음 원과 비교
            while(!stack.isEmpty() && circle.str > stack.peek()){
                stack.pop();
            }
            // circle 시작, 끝 사이에 비교 원이 있으면 invalid
            if(!stack.isEmpty() && circle.str <= stack.peek() && stack.peek() <= circle.end){
                flag = false;
                break;
            }
            stack.push(circle.end);
        }
        if(!flag) System.out.print("NO");
        else System.out.print("YES");

    }
}