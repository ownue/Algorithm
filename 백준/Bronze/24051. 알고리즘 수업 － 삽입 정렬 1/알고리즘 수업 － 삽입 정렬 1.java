import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];
        int count = 0;
        int result = -1;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 1; i < N; i++) {
            int num = A[i];
            int j = i - 1;

            while (j >= 0 && A[j] > num) {
                A[j + 1] = A[j]; // 값을 오른쪽으로 이동
                count++;

                if (count == K) {
                    result = A[j + 1];
                    break;
                }
                j--;
            }

            if (count == K) break;

            // 최종 삽입
            if (A[j + 1] != num) { // 자기 자리 그대로일 때 중복 카운트 방지
                A[j + 1] = num;
                count++;

                if (count == K) {
                    result = num;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}