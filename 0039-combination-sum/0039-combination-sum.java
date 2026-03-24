class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,target,0,new ArrayList<>(),res);
        return res;
    }

    void dfs(int[] nums,int t,int i,List<Integer> cur,List<List<Integer>> res){
        if(t==0){ res.add(new ArrayList<>(cur)); return; }
        if(i==nums.length || t<0) return;

        cur.add(nums[i]);
        dfs(nums,t-nums[i],i,cur,res);
        cur.remove(cur.size()-1);

        dfs(nums,t,i+1,cur,res);
    }
}