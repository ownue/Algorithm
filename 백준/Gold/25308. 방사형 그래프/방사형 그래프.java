import java.util.*;

public class Main {
    static int[] len = new int[8]; // 입력 받은 길이
    static double[] angleRad = new double[8];    // 각도
    static int[] perm = new int[8]; // 순열 기록할 배열
    static boolean[] visited = new boolean[8];  // 방문 기록
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 8; i++) {
            len[i] = sc.nextInt();
            angleRad[i] = Math.toRadians(45 * i); // 라디안 단위 저장
        }

        // 첫 번째 위치를 i번째 길이로 고정시키고 7!개의 순열 만들기
        for (int i = 0; i < 8; i++) {
            perm[0] = i;
            visited[i] = true;
            DFS(1); // 나머지 7개 자리 순열 구성
            visited[i] = false;
        }

        System.out.println(count);
    }

    // 순열 만들기
    public static void DFS(int depth) { // 인자: 순열의 몇 번째 자리인가?
        if (depth == 8) {   // 마지막
            if (isConvex()) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {  // i를 이미 방문했으면 건너뜀
                visited[i] = true;  // 중복 호출 막기 위한 문장
                perm[depth] = i;    // 현재 깊이(인자)의 위치에 i를 넣음
                DFS(depth + 1); // 다음 숫자 채우기
                visited[i] = false; // 재귀 다 끝나고 i 다시 사용할 수 있도록 하기
            }
        }
    }

    // 만든 순열로 볼록성 판별하기
    public static boolean isConvex() {
        double[] x = new double[8];
        double[] y = new double[8];

        // 현재 순열의 길이에 따라 좌표 계산
        for (int i = 0; i < 8; i++) {
            int idx = perm[i];
            x[i] = len[idx] * Math.cos(angleRad[i]);
            y[i] = len[idx] * Math.sin(angleRad[i]);
        }

        // CCW 체크: 모두 같은 방향이면 볼록
        double prev = 0;
        for (int i = 0; i < 8; i++) {
            double ccw = CCW(
                    x[i], y[i],
                    x[(i + 1) % 8], y[(i + 1) % 8],
                    x[(i + 2) % 8], y[(i + 2) % 8]
            );
            if (ccw == 0) continue; // 일직선이 나와도 180 이하에 해당하므로 가능
            if (prev == 0) {
                prev = ccw;
            } else if (prev * ccw < 0) { // 이전 값과 곱했을 때 음수가 나오면
                return false; // 중간에 방향 바뀜 == 오목함
            }
        }
        return true;
    }

    public static double CCW(double x1, double y1, double x2, double y2, double x3, double y3) {
        return (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
    }
}