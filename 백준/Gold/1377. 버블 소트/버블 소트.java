import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean changed = false;
        int maxNum = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());   // 배열의 크기
        int[][] A = new int[N][2];    // N개를 (i, j) 형태로 입력받을 수 있음


        for (int i = 0; i < N; i++) {   // 배열 입력
            int num = Integer.parseInt(br.readLine());
            A[i][0] = i;
            A[i][1] = num;
        }

        Arrays.sort(A, (o1, o2) -> {
            return o1[1] - o2[1];   // 오름차순 정렬
        });

        for (int i = 0; i < N; i++) {
            int a1 = A[i][0] - i;
            if (a1 > maxNum) maxNum = a1;
        }

        System.out.println(maxNum + 1);
    }
}