import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] arr = new long[N];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long max = arr[N - 1];
            long profit = 0;
            for (int k = N - 2; k >= 0; k--) {
                if (arr[k] > max) {
                    max = arr[k];
                } else if (arr[k] < max) {
                    profit += max - arr[k];
                }
            }

            System.out.println(profit);
        }
    }
}