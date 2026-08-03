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
    public TreeNode helper(TreeNode curr,int val){
        if(curr==null){
            return null;
        }
        if(curr.val==val){
            return curr;
        }
        if(curr.val<val){
                return helper(curr.right,val);
            }
        return helper(curr.left,val);
    }
    public TreeNode searchBST(TreeNode root, int val) {
        return helper(root,val);
    }
}