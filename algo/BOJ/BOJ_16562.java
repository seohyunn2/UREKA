package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16562 {
    // 모든 정점을 다 연결하는 트리 만들면 됨 (최소 비용으로)
    static int N, M, k;
    static int[] parents, cost;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        cost = new int[N+1];
        parents = new int[N+1];
        st = new StringTokenizer(in.readLine(), " ");
        // make()
        for(int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            parents[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }

        int res = 0;
        for(int i = 1; i <= N; i++) {
            if(parents[i] == i) { // 루트노드들만 합산
                res+=cost[i];
            }
        }

        if(res <= k) {
            System.out.println(res);
        } else {
            System.out.println("Oh no");
        }
    }

    public static int find(int v) {
        if(parents[v]==v) {
            return v;
        }
        return parents[v] = find(parents[v]);
    }

    // union()
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) {
            if(cost[rootA] >= cost[rootB]) {
                parents[rootA] = rootB;
            } else if(cost[rootA] < cost[rootB]) {
                parents[rootB] = rootA;

            }
        }

    }
}