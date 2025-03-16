import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 21921 블로그
* */

public class Main {
   private static int count = 1;

    // 슬라이딩 윈도우로 합의 최댓값을 구하고, 배열에 저장하는 메서드
    public static int sumArray(int[] arr, int N, int[] sumArr) {
        int maxSum = 0, windowSum = 0;

        for (int i = 0; i < N; i++) {
            windowSum += arr[i];
            sumArr[i] = windowSum;
        }
        maxSum = windowSum;

        // 슬라이딩 윈도우 이동
        for (int i = N; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - N];   // 새로운 값 추가, 이전 값 제거
            sumArr[i] = windowSum;
            if (maxSum < windowSum) { // 최댓값 갱신
                maxSum = windowSum;
                count = 1;
            } else if (maxSum == sumArr[i]) {
                count++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    // N과 X 받아오기
        int fullDays = Integer.parseInt(st.nextToken());// 전체 일자 N일
        int dayNum = Integer.parseInt(st.nextToken());  // 방문자 수를 합할 날짜 단위 X일
        int[] visitNum = new int[fullDays];  // 방문자수 받아올 배열

        st = new StringTokenizer(br.readLine());    // 방문자 수 전체 받아오기
        for (int i = 0; i < fullDays; i++) {
            visitNum[i] = Integer.parseInt(st.nextToken());    // 하나씩 끊는 중
        }

        int[] sumArr = new int[fullDays];
        int maxVisitNum = sumArray(visitNum, dayNum, sumArr);

        if (maxVisitNum == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(maxVisitNum);
        System.out.println(count);
    }
}