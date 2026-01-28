import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result, row, col;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                row = i;
                col = j;
                result = 0;

                while (true) {
                    int rowR = row % 3;
                    int colR = col % 3;

                    if (rowR == 1 && colR == 1) {
                        result = 1;
                        break;
                    }

                    if (row < 3 || col < 3) break;

                    row = row / 3;
                    col = col / 3;
                }

                switch (result) {
                    case 0: sb.append("*"); break;
                    case 1: sb.append(" "); break;
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}