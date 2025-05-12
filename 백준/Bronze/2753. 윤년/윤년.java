import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        boolean isLeap = false;

        if (input % 4 == 0) {   // 4의 배수
            if (input % 100 != 0 || input % 400 == 0) {
                isLeap = true;
            }
        }

        int result = isLeap ? 1 : 0;
        System.out.println(result);
    }
}