package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static int N, M;
    static int day = 0;
    static int[][] map;
    static int[][] visited;
    static Queue<int[]> tomato;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    // 큐 하나로도 구현 가능
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];
        tomato = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    tomato.offer(new int[]{i, j});
                }
            }
        }
        BFS();

        // 다시 탐색하면서 0이 나오면 -1 출력
        for(int i = 0; i < N; i++) {
            for(int j =0; j < M; j++) {
                if(map[i][j] == 0) {
                    day = -1;
//                    System.out.println(-1);
                    break;
                }
            }
        }
        if(day > 1) {
            System.out.println(day - 1); // +1 하고 시작했으니까
        }  else if(day == -1) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }
    }

    public static void BFS() {
        int[] cur;
        int row, col, nr, nc;

        while(!tomato.isEmpty()) {
            int tSize = tomato.size();
            day++;
            for(int i = 0; i < tSize; i++) {
                cur = tomato.poll();
                row = cur[0];
                col = cur[1];

                for(int j = 0; j < 4; j++) {
                    nr = row + dr[j];
                    nc = col + dc[j];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if(map[nr][nc] == 0) {
                        map[nr][nc] = 1;
                        tomato.offer(new int[]{nr, nc});
                    }
                }
            }
        }


    }
}
