package BOJ;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1922 {
    static int N, M;



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine(), " ");
        M = Integer.parseInt(st.nextToken());


        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j = 0; j < 3; j++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
            }
        }
    }
}
