class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("",0,0,n,res);
        return res;
    }

    void dfs(String s,int open,int close,int n,List<String> res){
        if(s.length()==2*n){ res.add(s); return; }

        if(open<n) dfs(s+"(",open+1,close,n,res);
        if(close<open) dfs(s+")",open,close+1,n,res);
    }
}