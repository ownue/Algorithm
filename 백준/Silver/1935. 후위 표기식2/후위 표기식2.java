import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int N;
    static String str;
    static double[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new double[N];

        // 한 글자씩 쪼개서 String 배열에 넣기
        str = br.readLine();

        // N개의 피연산자에 대응하는 숫자 받기 (100 이하 자연수)
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'A' && ch <='Z') {
                // 배열에 넣어둔 값으로 넣기
                s.push(arr[ch - 'A']);
            }

            else {
                // 먼저 나오는 게 우측항
                double right = s.pop();
                double left = s.pop();

                double result = 0;
                switch(ch) {
                    case '+': result = right + left; break;
                    case '-': result = left - right; break;
                    case '*': result = left * right; break;
                    case '/': result = left / right; break;
                }

                s.push(result);
            }
        }

        System.out.printf("%.2f", s.pop());
    }
}