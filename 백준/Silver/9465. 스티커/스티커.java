import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        int T, n;
        BufferedReader br;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[n][2];
            int[][] result = new int[n][3];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sticker[j][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sticker[j][1] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            result[0][0] = sticker[0][0];
            result[0][1] = sticker[0][1];
            result[0][2] = 0;

            for (int j = 0; j < n - 1; j++) {
                result[j+1][0] = Math.max(result[j][1] + sticker[j+1][0], result[j][2] + sticker[j+1][0]);
                result[j+1][1] = Math.max(result[j][0] + sticker[j+1][1], result[j][2] + sticker[j+1][1]);
                result[j+1][2] = Math.max(result[j][0], Math.max(result[j][1], result[j][2]));
            }

            max = Math.max(max, Math.max(result[n-1][1], Math.max(result[n-1][0], result[n-1][2])));
            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}