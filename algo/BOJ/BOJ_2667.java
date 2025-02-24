package BOJ;
import java.util.*;
import java.io.*;

public class BOJ_2667 {
    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    // 단지수별로 집의 개수 담기
    static List<Integer> house = new ArrayList<>();
    static boolean[][] visited;
    static int cnt;
    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        // 지도 입력받기
        for(int i = 0; i < N; i++) {
            String line = in.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 구획 탐색
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == '1') {
                    bfs(i, j);
                }
            }
        }
        Collections.sort(house);
        System.out.println(house.size());
        for(int i = 0; i < house.size(); i++) {
            System.out.println(house.get(i));
        }
    }

        // bfs 구현
    public static void bfs(int r, int c) {
        visited[r][c] = true;
        q.offer(new int[] {r, c});
        int nr, nc;
        cnt = 1; // 첫 번째도 포함해야되니까

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            // 상하좌우 확인
            for(int i = 0; i < 4; i++) {
                nr = cur[0] + dr[i];
                nc = cur[1] + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(visited[nr][nc] || map[nr][nc] == '0') continue;

                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc});

                cnt++;
            }
        }
        house.add(cnt);
    }
    // 단지 번호를 붙일 수도 있엄
}
