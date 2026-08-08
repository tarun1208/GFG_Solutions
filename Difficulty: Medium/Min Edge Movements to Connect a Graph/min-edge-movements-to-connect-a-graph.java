class Solution {
    int[] parent;

    int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    public int minEdgesReq(int n, int[][] edges) {
        if (edges.length < n - 1) return -1;

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int components = n;
        for (int[] e : edges) {
            int root1 = find(e[0]);
            int root2 = find(e[1]);
            if (root1 != root2) {
                parent[root1] = root2;
                components--;
            }
        }

        return components - 1;
    }
}