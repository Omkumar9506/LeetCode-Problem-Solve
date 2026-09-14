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
    public boolean isValidBST(TreeNode root) {
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validBST(TreeNode root, long minValue, long maxValue){
        if(root==null){
            return true;
        }
        if(root.val>=maxValue || root.val<=minValue){
            return false;
        }
        return validBST(root.left, minValue, root.val) && validBST(root.right, root.val, maxValue);
    }
}