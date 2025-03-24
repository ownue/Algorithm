import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        int t = sc.nextInt();
        boolean flag = true;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String str = sc.next();

            // str 길이만큼 반복
            for (int j = 0; j < str.length(); j++) {
                // 처음부터 ')'이 들어있다면 바로 NO 출력
                if (str.charAt(j) == ')' && j == 0) {
                    sb.append("NO").append("\n");
                    flag = false;
                    break;
                } else if (str.charAt(j) == '(') {
                    stack.push(j);  // '(' 라면 스택에 추가
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();    // ')'가 나왔고, 스택에 원소가 있다면 하나 제거
                    } else {
                        sb.append("NO").append("\n");   // 스택이 비어있다면 NO 출력
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                if (stack.isEmpty()) {  // 짝이 맞는 경우
                    sb.append("YES").append("\n");
                } else {    // 짝이 안 맞을 경우 ('('가 더 많은 경우)
                    sb.append("NO").append("\n");
                }
            }

            stack = new ArrayDeque<>(); // 스택 초기화
            flag = true;    // 플래그 초기화
        }

        System.out.println(sb.toString());
    }
}