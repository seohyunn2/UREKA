package BOJ;

import java.util.*;

public class BOJ_2720 {
    // 0.25, 0.10, 0.05, 0.01

    static final int[] coin = {25, 10, 5, 1};
    static int T, C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            // 함수 호출
            C = sc.nextInt();
            getAnswer(C);
        }
    }

    // 거스름돈 개수 구해서 출력하는 함수
    public static void getAnswer(int input) {
        int[] ans = new int[4];

        for(int i = 0; i < coin.length; i++) {
            ans[i] = input/coin[i];
            input %= coin[i];
            System.out.printf("%d ", ans[i]);
        }
        System.out.println();
    }
}
