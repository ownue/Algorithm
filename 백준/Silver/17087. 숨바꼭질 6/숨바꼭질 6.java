import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] dist = new int[N];
        int g = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            dist[i] = Math.abs(S - Integer.parseInt(st.nextToken()));

            if (i == 0) g = dist[0];
            g = gcd(g, dist[i]);
        }

        System.out.println(g);
    }

    static int gcd(int a, int b) {
        // 더 작은 수(b)가 0이 되면 a가 gcd
        while (b != 0) {
            int r = a % b;  // 나머지 구하고
            a = b;  // 작은 쪽을 큰 쪽에 대입
            b = r;  // 나머지는 작은 쪽에 대입
        }
        return a;
    }
}