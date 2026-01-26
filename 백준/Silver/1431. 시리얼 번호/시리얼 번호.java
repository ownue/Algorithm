import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(i, new Node(br.readLine()));
        }

        list.sort((a, b) -> {
            int aSize = a.size;
            int bSize = b.size;

            if (aSize != bSize) {
                // 사이즈 오름차순
                return aSize - bSize;
            } else {
                // 숫자 합
                if (a.sum != b.sum) {
                    return a.sum - b.sum;
                }
                // 문자열 오름차순
                return a.str.compareTo(b.str);
            }
        });

        for (Node node : list) {
            sb.append(node.str).append("\n");
        }

        System.out.println(sb);
    }

    static class Node {
        String str;
        int size;
        int sum;

        Node(String str) {
            this.str = str;
            this.size = str.length();
            this.sum = 0;
            for (int i = 0; i < this.size; i++) {
                // 0~9 사이의 숫자인 경우
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    sum += str.charAt(i) - '0';
                }
            }
        }
    }
}