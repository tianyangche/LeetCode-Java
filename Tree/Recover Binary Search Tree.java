/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        
        TreeNode[] pre = new TreeNode[1];
        TreeNode[] first = new TreeNode[1];
        TreeNode[] second = new TreeNode[1];

        helper(root, pre, first, second);
        
        int temp = first[0].val;
        first[0].val = second[0].val;
        second[0].val = temp;
    }
    
    private void helper(TreeNode root, TreeNode[] pre, TreeNode[] first, TreeNode[] second) {
        if (root == null) {
            return;
        }
        
        helper(root.left, pre, first, second);
        
        if (pre[0] != null && pre[0].val > root.val) {
            if (first[0] == null) {
                first[0] = pre[0];
            }
            
            second[0] = root;
        }
        
        pre[0] = root;
        
        helper(root.right, pre, first, second);
    }
}