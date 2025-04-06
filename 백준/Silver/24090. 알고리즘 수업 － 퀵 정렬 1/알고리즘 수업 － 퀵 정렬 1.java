import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());    // 배열의 크기
        int K = Integer.parseInt(st.nextToken());    // 교환 횟수

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {   // 배열에 입력
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, N-1, K);  // 인덱스로 사용해야 하므로 right == N-1

        if (!found) {
            System.out.println(-1);
        }
    }

    public static void quickSort(int[] arr, int left, int right, int K) {
        if (left < right && !found) {
            int pivot = partition(arr, left, right, K);
            quickSort(arr, left, pivot - 1, K);    // 왼쪽 부분 정렬
            quickSort(arr, pivot + 1, right, K);   // 오른쪽 부분 정렬
        }
    }

    public static int partition(int[] arr, int left, int right, int K) {
        int pivot = arr[right]; // 오른쪽 피벗
        int i = left - 1;   // i는 피벗보다 작은 값들 구간의 끝 인덱스를 나타내기 위함
        for (int j = left; j < right; j++) {    // 왼쪽 끝부터 오른쪽-1(피벗 전)까지 순회
            if (arr[j] < pivot) {   // 만약 순회 중인 것이 pivot보다 작다면 (앞으로 가야 함)
                swap(arr, ++i, j, K);   // 작은 값이 나오면 i+1 위치 (작은 애들을 앞에 정렬하기 위함) 에 옮김
            }
        }
        if (i + 1 != right) {
            swap(arr, i + 1, right, K); // 피벗을 중앙에 위치하게 함
        }
        return i + 1;   // 작은 값들의 구간 뒤에 피벗을 넣기 위해서!
    }

    public static void swap(int[] arr, int a, int b, int K) {
        count++;
        if (count == K) {
            int min = Math.min(arr[a], arr[b]);
            int max = Math.max(arr[a], arr[b]);
            System.out.println(min + " " + max);
            found = true;
        }

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}