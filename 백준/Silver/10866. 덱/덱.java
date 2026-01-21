import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        int N, result = 0;
        StringBuilder sb;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push_front":
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (!deque.isEmpty()) result = deque.pollFirst();
                    else result = -1;
                    sb.append(result).append("\n");
                    break;
                case "pop_back":
                    if (!deque.isEmpty()) result = deque.pollLast();
                    else result = -1;
                    sb.append(result).append("\n");
                    break;
                case "size":
                    result = deque.size();
                    sb.append(result).append("\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) result = 1;
                    else result = 0;
                    sb.append(result).append("\n");
                    break;
                case "front":
                    if (!deque.isEmpty()) result = deque.peekFirst();
                    else result = -1;
                    sb.append(result).append("\n");
                    break;
                case "back":
                    if (!deque.isEmpty()) result = deque.peekLast();
                    else result = -1;
                    sb.append(result).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}