import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;

        if (N == 1) result = 1;
        else if (N == 2) {
            result = Math.min(3, (M - 1) / 2) + 1;
        }
        else {
            if (M <= 3) {
                result = M;
            } else if (M < 7) {
                // 열이 모자라서 네 가지 이동 방법 사용이 불가능...
                // 하지만, 세 번 이동 내에서는 자유롭게 이동이 가능하므로 항상 4
                result = 4;
            } else {    // M >= 7이므로 네 가지 이동 모두 사용 가능
                // 이제는 위아래로 왔다갔다 하면서 이동하는 게 가능하므로, 열만 신경쓰면 됨
                // 최적은 그럼 열을 한 칸씩만 이동하는 것이므로,
                // 열을 6칸 이동한 뒤에는 한 칸씩만 이동한다고 상정하고 개수를 셀 수 있음!
                // 즉, 7칸을 사용해서 지금 5번을 이동했고,
                // 앞으로는 한 칸씩만 이동할 거라서 M - 2로 축약 가능!
                result = M - 2;
            }
        }

        System.out.println(result);
    }
}