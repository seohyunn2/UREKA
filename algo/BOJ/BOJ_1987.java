package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
    static int R, C;
    static char[][] map;
    static boolean[] alphabet = new boolean[26];
    static int maxDistance = Integer.MIN_VALUE;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    // 최대 몇 칸 갈 수 있는지?
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i = 0; i < R; i++) {
            String line = in.readLine();
            for(int j = 0; j  < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        DFS(0, 0);

        System.out.println(maxDistance);

    }

    public static void DFS(int i, int j) {

        char c = map[i][j];
        alphabet[c - 'A'] = true; // 방문 처리

        int nr, nc;
        cnt++;
        for(int k = 0; k < 4; k++) {

            nr = i + dr[k];
            nc = j + dc[k];

            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue; // 범위 밖에 있으면
            if(alphabet[map[nr][nc] - 'A']) continue; // 이미 방문 했으면
            DFS(nr, nc);
        }

        maxDistance = Math.max(maxDistance, cnt);
        alphabet[map[i][j] - 'A'] = false;
        cnt--;

    }
}
