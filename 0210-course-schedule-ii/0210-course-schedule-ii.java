class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        int[] indeg = new int[n];

        for (int[] p : pre) {
            g.get(p[1]).add(p[0]);
            indeg[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (indeg[i] == 0) q.add(i);

        int[] res = new int[n];
        int idx = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            res[idx++] = u;

            for (int v : g.get(u)) {
                if (--indeg[v] == 0)
                    q.add(v);
            }
        }

        return idx == n ? res : new int[0];
    }
}