import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    private static int[] parents; // 연결 성분의 대표 노드 저장

    public static void union(int a, int b) {
        a = find(a);    // a의 연결 성분의 대표 노드 찾기
        b = find(b);    // b의 연결 성분의 대표 노드 찾기
        if (a != b) parents[b] = a;
    }

    public static int find(int a) { // 재귀 & 연결 성분의 대표 노드 찾기
        if (a == parents[a]) {
            return a;
        } else {
            return parents[a] = find(parents[a]);  // 부모 계속 찾아!!
        }
    }

    // 도시에서 0 사용 안 함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()) + 1;    // 도시의 수 + 1 (0 사용 안 함)
        M = Integer.parseInt(br.readLine());    // 여행 계획에 속한 도시들의 수
        parents = new int[N];   // 초기화를 main 내부에서 해줘야 함

        // parents 배열 자기자신으로 초기화
        for (int i = 1; i < N; i++) {   // 1~N-1까지 접근해야 함
            parents[i] = i;
        }

        // 행렬 확인하고 union & find
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }
        String result = "YES";

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = find(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < M - 1; i++) {
            if (find(Integer.parseInt(st.nextToken())) != k) {
                result = "NO";
                break;
            }
        }

        System.out.println(result);
    }
}