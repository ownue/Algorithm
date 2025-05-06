import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 문제의 수
        int M = Integer.parseInt(st.nextToken());   // 정보 개수

        // 인접 리스트 만들기
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {   // 문제 수만큼 리스트 만들기 (헤드 포인트 크기그 N)
            A.add(new ArrayList<>());
        }

        // 진입 차수 배열
        int[] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A.get(a).add(b);    // a를 가져와서 b 넣음
            indegree[b]++;      // b의 진입차수 1 증가
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i < N+1; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");
            for (Integer i : A.get(now)) {
                indegree[i]--;  // 진입 차수 감소
                if (indegree[i] == 0) {
                    q.offer(i); // 진입 차수가 0인 노드를 큐에 넣음
                }
            }
        }
        System.out.println(sb.toString());
    }
}