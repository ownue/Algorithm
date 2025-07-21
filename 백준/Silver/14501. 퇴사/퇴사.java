import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N];
        int[] P = new int[N];
        int[] D = new int[N + 1];

        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int j = N-1; j >= 0; j--) {
            if (j + T[j] <= N) {
                D[j] = Math.max(P[j] + D[j + T[j]], D[j + 1]);
            } else D[j] = D[j + 1];
        }

        System.out.println(D[0]);
    }
}