import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        boolean isSwapped = false;

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 5; j > 0; j--) {   // 큰 루프
            for (int k = 0; k < j - 1; k++) {   // 작은 루프 (앞/뒤 비교, 뒤부터 정렬됨)
                if (arr[k] > arr[k + 1]) {  // 앞이 뒤보다 크다면 swap
                    int tmp = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1] = tmp;

                    isSwapped = true;    // k 루프를 돌 때 swap이 한 번이라도 일어났으면 true

                    for (int n : arr) {
                        sb.append(n).append(" ");
                    }
                    sb.append("\n");
                }
            }
            if (!isSwapped) break;   // swap이 한 번도 안 일어났으면 j 반복문 끝
            isSwapped = false;
        }
        System.out.println(sb);
    }
}