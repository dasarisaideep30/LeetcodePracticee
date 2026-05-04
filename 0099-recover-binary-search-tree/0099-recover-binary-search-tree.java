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
    TreeNode first = null , second = null , prev = null;
    public void recoverTree(TreeNode root) {
        dfs(root);
        int t = first.val;
        // int t = first.data;
        first.val = second.val;
        // first.data = second.data;
        second.val = t;
        // second.data = t;
    }
    void dfs(TreeNode r){
        // void dfs(Node r)
        if(r==null){
            return;
        }
        dfs(r.left);
        if(prev!=null && r.val<prev.val){
            if(first==null){
                first=prev;
            }
            second=r;
        }
        // if(prev!=null && r.data<prev.data){
        //     if(first==null){
        //         first=prev;
        //     }
        //     second=r;
        // }
        prev=r;
        dfs(r.right);
    }
}