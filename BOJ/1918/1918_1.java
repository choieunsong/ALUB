/**
* 메모리: 11516 KB, 시간: 76 ms
* 2021.12.01
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(in.readLine());

        Stack<Character> stack = new Stack<Character>();
        StringBuilder str = new StringBuilder();

        while(!stack.isEmpty()){
            System.out.println("empty?");
        }

        for(int i=0; i<sb.length(); i++){
            char ch = sb.charAt(i);

            if('A' <= ch && ch <= 'Z')  str.append(ch);
            else if(ch == '(')  stack.push(ch);
            else if(ch == ')'){
                while(!stack.isEmpty() && stack.peek() != '(')  str.append(stack.pop());
                stack.pop();
            }else if(ch == '+' || ch == '-'){
                while(!stack.isEmpty() && (stack.peek() != '('))  str.append(stack.pop());
                stack.push(ch);
            }else if(ch == '*' || ch == '/'){
                while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/'))  str.append(stack.pop());
                stack.push(ch);
            }
//            System.out.println(str);
        }
        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
                str.append(stack.pop());
            }
        }
        System.out.println(str);
    }
}