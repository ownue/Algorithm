import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sorted = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        /*
        * 자꾸 N을 넣는 실수를 하는데
        * 포인터를 넣는 거라서 N-1을 넣어야 예외가 발생하지 않음
        * */
        mergeSort(arr, sorted, 0, N-1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i] + "\n");
        }

        System.out.println(sb.toString());
    }

    public static void mergeSort(int[] arr, int[] sorted, int start, int end) {
        if (start >= end) return;   // 종료 조건
                                    // 궁금한 점: start == end를 조건으로 하면 예외가 존재하는가? -> 존재하지 않을 듯

        int mid = (start + end) / 2;

        // 분할
        mergeSort(arr, sorted, start, mid);
        mergeSort(arr, sorted, mid + 1, end);

        // 정복
        int i = start, j = mid + 1, k = start;  // 처음에는 k = 0 으로 했는데 생각해보니 k는 start가 시작점!
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                sorted[k++] = arr[i++];
            }
            else sorted[k++] = arr[j++];
        }

        while (i <= mid) {
            sorted[k++] = arr[i++];
        }

        while (j <= end) {
            sorted[k++] = arr[j++];
        }

        for (int l = start; l <= end; l++) {    // < end가 아니라 <= end로 해야 됨! (start~end가 범위)
            arr[l] = sorted[l]; // 원본 배열에 복사
        }
    }
}