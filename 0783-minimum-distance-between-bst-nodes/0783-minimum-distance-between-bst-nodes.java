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
    int prev = -1;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }
    void dfs(TreeNode root){
        // void dfs(Node root){}
        if(root==null){
            return;
        }
        dfs(root.left);
        if(prev!=-1){
            min = Math.min(min,root.val-prev);
        }
        // if(prev!=-1){
        //     min = Math.min(min,root.data-prev);
        // }
        prev=root.val;
        // prev=root.data;
        dfs(root.right);
    }
}