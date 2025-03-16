import java.util.Scanner;
import java.util.Arrays;

/*
* 1940 주몽
* */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nMaterial = sc.nextInt();    // 재료의 개수
        int mNeeds = sc.nextInt();  // 갑옷을 만드는 데 필요한 수
        int[] originNum = new int[nMaterial];    // 재료 고유의 번호 배열
        int start = 0;  // 좌측 포인터 인덱스
        int end = nMaterial - 1; // 우측 포인터 인덱스
        int sum = 0;    // 합
        int count = 0;  // M이 되는 순서쌍의 개수

        for (int i = 0; i < nMaterial; i++) {
            originNum[i] = sc.nextInt();
        }

        Arrays.sort(originNum); // 정렬 메서드

        // 두 포인터가 닿으면 break
        while (start < end) {
            sum = originNum[start] + originNum[end];
            if (sum > mNeeds) { // 합이 M보다 크면
                end--;
            } else if (sum < mNeeds) {  // 합이 M보다 작으면
                start++;
            } else {
                count++;
                start++;
                end--;
            }
        }

        System.out.println(count);
    }
}