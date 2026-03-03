import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        // 배열 채우기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        quadtree(arr, 0, 0, N);
        System.out.println(sb.toString());
    }

    // 압축이 가능한지 판별
    public static boolean zippable(int[][] arr, int row, int col, int size) {
        if (size == 1) return true;

        int pointer = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != pointer) return false;
            }
        }

        return true;
    }

    // 쿼드트리
    public static void quadtree(int[][] arr, int row, int col, int size) {
        // 압축이 가능하다면
        if (zippable(arr, row, col, size)) {
            if (arr[row][col] == 0) { sb.append(0); }
            else { sb.append(1); }
        }
        // 압축이 불가능하다면
        else {
            int half = size / 2;
            sb.append("(");
            quadtree(arr, row, col, half);  // 좌상
            quadtree(arr, row, col + half, half);  // 우상
            quadtree(arr, row + half, col, half);  // 좌하
            quadtree(arr, row + half, col + half, half);  // 우하
            sb.append(")");
        }
    }
}