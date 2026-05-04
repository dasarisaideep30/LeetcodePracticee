class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(color[i]==0 && !dfs(graph,i,color,1)) return false;
        }
        return true;
    }
    boolean dfs(int[][]g,int node,int[]c,int col){
        c[node]=col;
        for(int nei:g[node]){
            if(c[nei]==0){
                if(!dfs(g,nei,c,-col)) return false;
            }
            else if(c[nei]==col) return false;
        }
        return true;
    }
}