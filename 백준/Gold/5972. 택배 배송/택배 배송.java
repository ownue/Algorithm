import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[] distance;   // 거리 배열
    public static boolean[] visited;    // 방문 여부 배열
    public static ArrayList<Edge>[] list;   // Integer 타입 인접 리스트
    public static PriorityQueue<Edge> q = new PriorityQueue<>();    // Integer 타입 큐

    static class Edge implements Comparable<Edge> {
        int v, weight;
        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
        public int compareTo(Edge o) {
            return this.weight - o.weight;  // 오름차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 헛간 개수
        M = Integer.parseInt(st.nextToken());   // edge 개수

        distance = new int[N + 1];
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {  // 인접리스트 생성
            list[i] = new ArrayList<>();
        }

        Arrays.fill(distance, Integer.MAX_VALUE);   // 거리 초기화
        Arrays.fill(visited, false);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A_i = Integer.parseInt(st.nextToken());
            int B_i = Integer.parseInt(st.nextToken());
            int C_i = Integer.parseInt(st.nextToken());
            list[A_i].add(new Edge(B_i, C_i));
            list[B_i].add(new Edge(A_i, C_i));
        }

        q.add(new Edge(1, 0)); // 출발 노드 우선순위 큐에 삽입
        distance[1] = 0;

        while (!q.isEmpty()) {
            Edge curr = q.poll();
            int c_v = curr.v;
            if (visited[c_v]) continue;
            visited[c_v] = true;

            for (Edge temp : list[c_v]) {
                int next = temp.v;
                int weight = temp.weight;

                if (distance[next] > distance[c_v] + weight) {
                    distance[next] = distance[c_v] + weight;    // 최소 거리 초기화
                    q.add(new Edge(next, distance[next]));
                }
            }
        }

        System.out.println(distance[N]);
    }
}