import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];
        int maxNum, maxIndex, count = 0;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 뒤에서부터 정렬
        for (int i = N - 1; i > 0; i--) {
            maxNum = A[i];
            maxIndex = i;

            for (int j = 0; j <= i - 1; j++) {
                if (maxNum < A[j]) {
                    maxNum = A[j];
                    maxIndex = j;
                }
            }


            A[maxIndex] = A[i];
            A[i] = maxNum;

            if (maxIndex != i) count++;

            if (count == K) break;
        }

        if (count != K) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append(" ");
        }

        System.out.println(sb);
    }
}