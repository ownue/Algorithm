import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (!q.isEmpty()) result = q.poll();
                    else result = -1;
                    System.out.println(result);
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if (q.isEmpty()) result = 1;
                    else result = 0;
                    System.out.println(result);
                    break;
                case "front":
                    if (!q.isEmpty()) result = q.peek();
                    else result = -1;
                    System.out.println(result);
                    break;
                case "back":
                    if (!q.isEmpty()) result = ((LinkedList<Integer>) q).peekLast();
                    else result = -1;
                    System.out.println(result);
                    break;
            }
        }
    }
}