import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 표의 크기 N
        int m = Integer.parseInt(st.nextToken());   // 계산 횟수 M
        int[][] arr = new int[n][n];    // 원본 배열 (2차원)
        int[][] sum = new int[n][n];   // 합 배열 (2차원)

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());    // 첫 번째 줄 읽기
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (i == 0 && j == 0) {
                    sum[i][j] = arr[i][j];
                } else if (i == 0) {
                    sum[i][j] = arr[i][j] + sum[i][j - 1];
                } else if (j == 0) {
                    sum[i][j] = arr[i][j] + sum[i - 1][j];
                } else {
                    sum[i][j] = arr[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                }
            }
        }

        StringBuilder sb = new StringBuilder(); // 출력이 늦어서 추가함
        int x1, x2, y1, y2, rmvTop, rmvLeft, addCorner, result;
        boolean isDifferent = true;

        for (int i = 0; i < m; i++) {
            isDifferent = true;

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken()) - 1;
            y1 = Integer.parseInt(st.nextToken()) - 1;
            x2 = Integer.parseInt(st.nextToken()) - 1;
            y2 = Integer.parseInt(st.nextToken()) - 1;

            if (x1 == x2 && y1 == y2) isDifferent = false;

            if (isDifferent) {
                rmvTop = (x1 > 0) ? sum[x1 - 1][y2] : 0;
                rmvLeft = (y1 > 0) ? sum[x2][y1 - 1] : 0;
                addCorner = (x1 > 0 && y1 > 0) ? sum[x1 - 1][y1 - 1] : 0;

                result = sum[x2][y2] - rmvTop - rmvLeft + addCorner;
            }
            else result = arr[x1][y1];

            sb.append(result).append("\n");
        }

        System.out.print(sb.toString());
    }
}