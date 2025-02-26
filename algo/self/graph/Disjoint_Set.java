package graph;

public class Disjoint_Set {
    static int N;
    static int[] parents;
    public static void make() {
        for(int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    public static int find(int v) {
        if(parents[v] == v) {
            return v;
        }
        // 원래는 그냥 return find(parents[v])
        // path compression은 그 값을 실제로 v의 부모로 넣어줌
        return parents[v] = find(parents[v]);
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) {
            return false;
        }
        parents[rootA] = rootB;
        return true;
    }

    public static void main(String[] args) {
        N=5;
        make();
    }
}
