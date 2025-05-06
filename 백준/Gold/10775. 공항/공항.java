import java.io.*;
import java.util.*;

public class Main {
    private static int G, P, k;
    private static int[] gates;

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) gates[b] = a;
    }

    public static int find(int a) {
        if (a == gates[a]) return a;
        return gates[a] = find(gates[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());    // 게이트의 수
        P = Integer.parseInt(br.readLine());    // 비행기의 수
        gates = new int[G + 1];     // 가능한 게이트를 기록할 배열
        int count = 0;

        // gates 배열 초기화
        for (int i = 0; i < G + 1; i++) {   // 0~G까지
            gates[i] = i;
        }

        // Union & Find 실행
        for (int i = 0; i < P; i++) {
            k = Integer.parseInt(br.readLine());
            int l = find(k);    // find로 도킹할 수 있는 가장 큰 게이트 찾기
            if (l == 0) break;  // 도킹할 수 있는 게이트가 없으면 종료

            union(l-1, l);  // 도킹 후 union 이용해서 같은 연결 성분으로 이어주기
            count++;    // 성공했으니 count 증가
        }
        System.out.println(count);
    }
}