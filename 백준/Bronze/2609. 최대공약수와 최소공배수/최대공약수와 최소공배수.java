import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int GCD = gcd(a, b);
        int LCM = a * b / GCD;
        System.out.println(GCD);
        System.out.println(LCM);
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