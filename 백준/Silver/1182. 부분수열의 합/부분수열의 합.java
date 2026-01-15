import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int S;
    static int count;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        // 공집합 제거
        if (S == 0) count -= 1;
        System.out.print(count);
    }

    static void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum == S) count++;
            return;
        }

        // 포함하는 경우 (sum 증가)
        dfs(idx + 1, sum + arr[idx]);
        // 포함하지 않는 경우 (sum 증가 x)
        dfs(idx + 1, sum);
    }
}