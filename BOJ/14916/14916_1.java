/**
* 메모리: 12852 KB, 시간: 108 ms
* 2022.03.31
* by Alub
*/
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        boolean isAns = false;
        while(n >= 0){
            if(n % 5 == 0){
                System.out.println(cnt + n/5);
                isAns = true;
                break;
            }
            n -= 2;
            cnt++;
        }
        if(!isAns){
            System.out.println(-1);
        }
    }
}