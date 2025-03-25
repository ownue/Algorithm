import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();   // N 입력
        int k = sc.nextInt();   // K 입력

        for (int i = 1; i <= n; i++) list.addLast(i);    // 링크드리스트에 원소 추가

        sb.append("<");
        ListIterator<Integer> it = list.listIterator();

        while (!list.isEmpty()) {
            for (int i = 1; i < k; i++) {
                if (!it.hasNext()) {    // 다음이 없으면
                    it = list.listIterator();   // 처음으로 돌아감
                }
                it.next();  // 0번째 원소에서 시작, 옆으로 하나씩 넘어감
            }

            if (!it.hasNext()) {    // 다음이 없으면
                it = list.listIterator();   // 처음으로 돌아감
                sb.append(it.next());
            } else sb.append(it.next());   // 다음 원소를 반환
            it.remove();    // 제거

            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}