import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            int k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            // 집합에 들어갈 애들
            int[] S = new int[k];
            int[] lottery = new int[6];

            // S 채우기
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            // 재귀
            findLottery(S, lottery, 0, 0);
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    static void findLottery(int[] S, int[] lottery, int idx, int lotteryCounts) {
        // 로또 완성
        if (lotteryCounts == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(lottery[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 끝까지 돌았거나 / 뽑은 숫자 + 남은 숫자가 6 미만일 경우
        if (idx == S.length || lotteryCounts + S.length - idx < 6) return;

        // 아직 끝까지 돌지 않았거나 더 뽑을 수 있는 경우
        for (int i = idx; i < S.length; i++) {
            lottery[lotteryCounts] = S[i];  // lotteryCounts + 1번째 원소를 넣음
            findLottery(S, lottery, i + 1, lotteryCounts + 1);
        }
    }
}