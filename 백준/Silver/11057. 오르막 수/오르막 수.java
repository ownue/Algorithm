import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        int n, result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][10];

        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i + 1][j] += dp[i][k];
                    dp[i + 1][j] %= 10007;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            result += dp[n - 1][i];
            result %= 10007;
        }

        System.out.println(result % 10007);
    }
}