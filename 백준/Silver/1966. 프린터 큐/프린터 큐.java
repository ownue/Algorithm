import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, N, M, printOrder;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        // 테스트 케이스 시작
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            Queue<Node> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st =  new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                q.offer(new Node(x, j));
                pq.offer(x);
            }

            printOrder = 0;
            while (true) {
                if (q.isEmpty() || pq.isEmpty() || printOrder == N) break;

                Node newNode = q.poll();
                int max = pq.peek();

                if (newNode.prior < max) {
                    q.offer(newNode);
                } else {
                    pq.poll();
                    printOrder++;

                    if (newNode.idx == M) {
                        System.out.println(printOrder);
                        break;
                    }
                }
            }
        }
    }

    static class Node {
        int prior;
        int idx;

        public Node(int x, int j) {
            this.prior = x;
            this.idx = j;
        }
    }
}