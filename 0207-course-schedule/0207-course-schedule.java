class Solution {
    public boolean canFinish(int n, int[][] pre) {
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

        int count = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            count++;

            for (int v : g.get(u)) {
                if (--indeg[v] == 0)
                    q.add(v);
            }
        }

        return count == n;
    }
}