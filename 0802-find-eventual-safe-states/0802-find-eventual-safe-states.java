class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < n; i++) rev.add(new ArrayList<>());

        int[] outdeg = new int[n];

        for (int i = 0; i < n; i++) {
            outdeg[i] = graph[i].length;
            for (int v : graph[i]) {
                rev.get(v).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (outdeg[i] == 0) q.add(i);

        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);

            for (int v : rev.get(u)) {
                if (--outdeg[v] == 0)
                    q.add(v);
            }
        }

        Collections.sort(res);
        return res;
    }
}