import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        Ingredient[] arr = new Ingredient[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new Ingredient(s, b);
        }

        // i가 1부터 noc까지 증가하므로 결국 noc 전까지의 이진수를 다 검사할 수 있음
        // 0(공집합) 제외해야 하므로 1부터 시작함
        for (int mask = 1; mask < 1<<N; mask++) {
            int sMul = 1;
            int bSum = 0;
            // 1이면 계산, 0이면 계산 X
            for (int j = 0; j < N; j++) {
                // j번째 비트 확인해서 0이 아니면 계산
                // 즉, j번째 재료를 넣어야 함
                if ((mask & (1<<j)) != 0) {
                    sMul *= arr[j].sour;
                    bSum += arr[j].bitter;
                }
            }
            if (Math.abs(sMul - bSum) < min) min = Math.abs(sMul - bSum);
        }

        System.out.println(min);
    }

    static class Ingredient {
        int sour;
        int bitter;

        public Ingredient(int sour, int bitter) {
            this.sour = sour;
            this.bitter = bitter;
        }
    }
}