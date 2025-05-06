import java.io.*;
import java.util.*;

public class Main {
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[] sorted = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sorted[i] = Integer.parseInt(st.nextToken());
        } Arrays.sort(sorted);

        int start = 1;  // 과자 길이는 1 이상이므로 1로 시작
        int end = sorted[N - 1];
        int result = 0;
        while (start <= end) {  // start < end로 하면 반례 존재
            int mid = (start + end) / 2;    // 가운데 값으로 mid 선택
            int count = 0;

            for (int i = 0; i < N; i++) {
                count += sorted[i] / mid; // 과자 i를 mid 길이로 자른 개수
            }

            if (count >= M) {
                start = mid + 1;
                result = mid;
            } else end = mid - 1;
        }
        System.out.println(result);
    }
}