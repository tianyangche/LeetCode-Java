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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int len = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.poll();
                
                if (peek.left == null && peek.right == null) {
                    return len;
                }
                
                if (peek.left != null) {
                    queue.offer(peek.left);
                }
                
                if (peek.right != null) {
                    queue.offer(peek.right);
                }
            }
            
            len++;
        }
        
        return len;
    }
}