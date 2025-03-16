import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. 배열 이용해서 풀기
        Scanner sc = new Scanner(System.in);
        int max_score = 0;
        int score = 0;
        double sum = 0;

        int nSubject = sc.nextInt();   // 몇 개 과목의 점수를 받을지 입력
        int[] scores = new int[nSubject];

        for (int i = 0; i < nSubject; i++) {
            score = sc.nextInt();
            scores[i] = score;
            max_score = Math.max(max_score, score);
        }

        for (int i = 0; i < nSubject; i++) {
            sum += scores[i] * 100.0 / max_score;
        }

        System.out.println(sum/nSubject);
    }
}