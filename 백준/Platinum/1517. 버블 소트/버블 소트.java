import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static long swapCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] sorted = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {   // 이차원 배열에 정렬 전 인덱스와 데이터
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, sorted, 0, N - 1);
        System.out.println(swapCount);
    }
    // merge sort 구현
    public static void merge_sort(int[] arr, int[] sorted, int s, int e) {
        if (s >= e) return;

        int mid = (s + e) / 2;

        merge_sort(arr, sorted, s, mid);
        merge_sort(arr, sorted, mid + 1, e);

        int i = s, j = mid + 1, k = s;  // i는 1번 그룹의 첫 인덱스, j는 2번 그룹의 첫 인덱스
        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                sorted[k++] = arr[i++];
            } else {    // j가 뒤에 있는 애들의 인덱스이므로, 역순쌍임! (swap 발생)
                sorted[k++] = arr[j++];
                swapCount += (mid - i + 1); // 앞지를 때
            }
        }
        while (i <= mid) {
            sorted[k++] = arr[i++];
        }
        while (j <= e) {
            sorted[k++] = arr[j++];
        }
        for (int l = s; l <= e; l++) {
            arr[l] = sorted[l];
        }
    }
}