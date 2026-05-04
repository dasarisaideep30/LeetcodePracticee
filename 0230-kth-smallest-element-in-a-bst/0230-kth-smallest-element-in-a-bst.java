/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int k, ans;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        // k=k;
        dfs(root);
        return ans;
    }
    void dfs(TreeNode r){
        // void dfs(Node r){}
        if(r==null){
            return;
        }
        dfs(r.left);
        if(--k==0){
            ans=r.val;
        }
        // if(--k==0){
        //     ans=r.data;
        // }
        dfs(r.right);
    }
}