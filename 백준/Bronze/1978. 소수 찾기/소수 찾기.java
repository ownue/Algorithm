import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());

            if (k == 1) continue;

            boolean isPrime = true;

            // k를 2부터 k의 제곱근까지 나누고, 나누어 떨어지면 그대로 / 나누어 떨어지지 않으면 count++;
            for (int j = 2; j*j <= k; j++) {
                if (k % j == 0) {
                    isPrime = false;
                    break;
                }
            } if (isPrime) {
                count++;
            }
        }

        System.out.println(count);
    }
}