import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, K, X;
    public static int[] distance;   // 거리 배열
    public static ArrayList<Integer>[] list;   // Integer 타입 인접 리스트
    public static Queue<Integer> q = new LinkedList<>();    // Integer 타입 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {  // 인접리스트 생성
            list[i] = new ArrayList<>();
        }

        Arrays.fill(distance, -1);   // 거리 초기화, 미방문은 -1

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);   // u 노드에 v와 이어진 edge 생성
        }

        q.add(X); // 출발 노드 우선순위 큐에 삽입
        distance[X] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list[now]) {
                if (distance[next] == -1) {
                    distance[next] = distance[now] + 1; // 방문한 적 없으면??
                    q.add(next);
                }
            }
        }

        // 다익스트라 알고리즘 완료 후
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                sb.append(i + "\n");
                found = true;
            }
        }

        System.out.println(found ? sb.toString() : "-1");
    }
}