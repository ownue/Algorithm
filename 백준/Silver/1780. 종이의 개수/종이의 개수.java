import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int minus = 0, zero = 0, plus = 0;

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
        System.out.println(minus + "\n" + zero + "\n" + plus);
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
            if (arr[x][y] == -1) { minus++; }
            else if (arr[x][y] == 0) { zero++; }
            else { plus++; }
        }
        // 내부의 값이 하나라도 다르다면 3 * 3으로 쪼개기
        else {
            int divide = size / 3;  // 3등분

            // 반복문으로 바꾸는 것도 가능
            count(arr, x, y, divide);   // 1
            count(arr, x, y + divide, divide);   // 2
            count(arr, x, y + 2 * divide, divide);   // 3
            count(arr, x + divide, y, divide);   // 4
            count(arr, x + divide, y + divide, divide);   // 5
            count(arr, x + divide, y + 2 * divide, divide);   // 6
            count(arr, x + 2 * divide, y, divide);   // 7
            count(arr, x + 2 * divide, y + divide, divide);   // 8
            count(arr, x + 2 * divide, y + 2 * divide, divide);   // 9
        }
    }
}