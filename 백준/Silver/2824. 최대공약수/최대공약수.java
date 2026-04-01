import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        long result = 1;
        boolean overflow = false;

        for (int i = 0; i < N; i++) {
            if (A[i] == 1) continue;

            for (int j = 0; j < M; j++) {
                if (B[j] == 1) continue;

                int g = gcd(A[i], B[j]);

                if (g > 1) {
                    A[i] /= g;
                    B[j] /= g;
                    result *= g;
                }

                if (result >= 1000000000) {
                    overflow = true;
                    result %= 1000000000;
                }

                if (A[i] == 1) break;
            }
        }

        if (overflow)
            System.out.printf("%09d", result);
        else
            System.out.println(result);

    }

    static int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        // 더 작은 수(b)가 0이 되면 a가 gcd
        while (b != 0) {
            int r = a % b;  // 나머지 구하고
            a = b;  // 작은 쪽을 큰 쪽에 대입
            b = r;  // 나머지는 작은 쪽에 대입
        }
        return a;
    }
}