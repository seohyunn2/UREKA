package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055 {
    static int R, C;
    static int[][] map, visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<int[]> water, move;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new int[R][C]; // 방문 여부 체크 + 값으로는 (i, j)까지 도달하는 데에 걸린 시간 저장함
        water = new ArrayDeque<>(); // 물 큐
        move = new ArrayDeque<>(); // 고슴도치 큐

        for(int i = 0; i < R; i++) {
            String line = in.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);

                if(map[i][j] == 'S') {
                    move.add(new int[]{i, j});
                    visited[i][j] = 1;
                } else if(map[i][j] == '*') {
                    water.add(new int[]{i, j});
                }
            }
        }
        int res = BFS();

        if(res == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(res);
        }
    }

    public static int BFS() {
        while(!move.isEmpty()) {
            // 물 먼저 확장
            int waterSize = water.size();
            for(int i = 0; i < waterSize; i++) {
                int[] curWater = water.poll();
                int curR = curWater[0];
                int curC = curWater[1];
                // 사방탐색 -> 비어있는 칸(.)이면 *로 바꿔주기
                for(int j = 0; j < 4; j++) {
                    int nr = curR + dr[j];
                    int nc = curC + dc[j];

                    if(nr >= 0 && nr < R && nc >= 0 && nc < C  && map[nr][nc] == '.') {
                        map[nr][nc] = '*';
                        water.add(new int[]{nr, nc});
                    }
                }
            }

            // 고슴도치 이동
            int moveSize = move.size();
            for(int i = 0; i < moveSize; i++) {
                int[] curMove = move.poll();
                int curR = curMove[0];
                int curC = curMove[1];

                for(int j = 0; j < 4; j++) {
                    int nr = curR + dr[j];
                    int nc = curC + dc[j];


                    if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if(visited[nr][nc] != 0) continue;
                    if(map[nr][nc] == '*' || map[nr][nc] == 'X') continue;

                    if(map[nr][nc] == 'D') {
//                        System.out.printf("도착 --- visited[%d][%d]\n", nr, nc);
                        return visited[curR][curC];
                    }

                    visited[nr][nc] = visited[curR][curC] + 1;
//                    System.out.printf("visited[%d][%d] 값 업데이트\n", nr, nc);
                    map[nr][nc] = 'S';
                    move.add(new int[]{nr, nc});
                }
            }
        }
        return -1;
    }
}




