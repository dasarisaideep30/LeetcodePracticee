class Solution {
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        return dfs(g, src, dest, vis);
    }

    boolean dfs(List<List<Integer>> g, int u, int dest, boolean[] vis) {
        if (u == dest) return true;

        vis[u] = true;

        for (int v : g.get(u)) {
            if (!vis[v] && dfs(g, v, dest, vis))
                return true;
        }
        return false;
    }
}