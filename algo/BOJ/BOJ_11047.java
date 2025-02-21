package BOJ;
import java.util.*;


public class BOJ_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N, K;
        N = sc.nextInt();
        K = sc.nextInt();
        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = sc.nextInt();
        }
        int cnt = 0;

        for (int i = N - 1; i >= 0; i--) {
            cnt += K / coin[i];
            K %= coin[i];
        }
        System.out.println(cnt);

    }
}
