import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());   // 숫자 개수(N) 받기
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            // Integer.parseInt()를 이용해서 정수 타입으로 배열에 삽입
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
//            System.out.println(arr[i]); 버퍼 writer로 출력해야 시간 단축 가능
            bw.write(arr[i] + "\n");    // '\n' 추가하면 char로 추론해서 오류남
        }

        bw.flush(); // 한 번에 출력
        br.close();
        bw.close();
    }
}