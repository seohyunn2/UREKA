package BOJ;

import java.util.*;

public class BOJ_5585 {
    static int[] coin = {500, 100, 50, 10, 5, 1};
    static int N, real;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        real = 1000 - N; // 거스름돈 양
        int sum=0;
        for(int i = 0; i < coin.length; i++) {
            sum += real/coin[i];
            real %= coin[i];
        }
        System.out.println(sum);
    }
}
