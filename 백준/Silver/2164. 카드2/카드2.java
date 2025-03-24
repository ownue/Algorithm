import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // N값 받음
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 1~N을 큐에 추가
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        // 데이터 빼내고 넣고 반복
        boolean flag = true;
        while (q.size() > 1) {
            if (flag) {
                q.poll();   // 처음엔 제거 (홀수 번째)
                flag = false;
            } else {
                q.offer(q.poll());  // 맨 위에서 제거하고 추가 (짝수 번째)
                flag = true;
            }
        }

        System.out.println(q.peek());
    }
}