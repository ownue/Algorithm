import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, W;
    static long[] distance;
    static ArrayList<Edge> edges;   // 배열 크기 동적으로 정해지게 하는 게 편함,,

    static class Edge {
        int start, end, time;
        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {   // TC번의 테스트 케이스 수행
            // 각 테스트 케이스의 N, M, W 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            distance = new long[N + 1];
//            int edgeCount = M * 2 + W + 1;
            edges = new ArrayList<>();
            Arrays.fill(distance, Integer.MAX_VALUE);

            for (int j = 0; j < M; j++) {   // 도로의 개수
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                edges.add(new Edge(start, end, time));  // 입력받은 값 이용해 edges 배열 채움
                edges.add(new Edge(end, start, time));  // 양방향이라 2번 저장
            }

            for (int j = 0; j < W; j++) {   // 웜홀의 개수
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken()) * -1;
                edges.add(new Edge(start, end, time));  // 입력받은 값 이용해 edges 배열 채움, 단방향이라 1번 저장
            }

            // 가상의 노드 0에서 모든 노드로 가중치 0인 간선 추가
            for (int j = 1; j <= N; j++) {
                edges.add(new Edge(0, j, 0));
            }

            // 거리 초기화 및 벨만포드 수행
            distance[0] = 0;
            for (int j = 0; j < N; j++) {
                for (Edge edge : edges) {
                    if (distance[edge.start] != Integer.MAX_VALUE &&
                            distance[edge.end] > distance[edge.start] + edge.time) {
                        distance[edge.end] = distance[edge.start] + edge.time;  // 최단 거리 업데이트
                    }
                }
            }

            boolean mCycle = false;
            for (Edge edge : edges) {
                if (distance[edge.start] != Integer.MAX_VALUE &&
                        distance[edge.end] > distance[edge.start] + edge.time) {
                    mCycle = true;
                    break;
                }
            }
            // 음수 사이클이 있으면 YES 출력
            System.out.println(mCycle ? "YES" : "NO");
        }
    }
}