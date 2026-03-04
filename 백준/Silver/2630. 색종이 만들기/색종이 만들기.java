import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int white = 0, blue = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        // 배열 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count(arr, 0, 0, N);
        System.out.println(white + "\n" + blue);
    }

    // 해당 구간이 모두 같은지 판별
    public static boolean isAllSame(int[][] arr, int x, int y, int size) {
        if (size == 1) return true;

        int pointer = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != pointer) return false;
            }
        }

        return true;
    }

    // 쿼드트리
    public static void count(int[][] arr, int x, int y, int size) {
        // 내부가 모두 같은 값이라면
        if (isAllSame(arr, x, y, size)) {
            if (arr[x][y] == 0) { white++; }
            else { blue++; }
        }
        // 내부의 값이 하나라도 다르다면 4개로 쪼개기
        else {
            int half = size / 2;  // 길이는 반으로

            count(arr, x, y, half);                        // 좌상
            count(arr, x, y + half, half);              // 우상
            count(arr, x + half, y, half);              // 좌하
            count(arr, x + half, y + half, half);    // 우하
        }
    }
}