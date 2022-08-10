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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int level = 1;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            while (size > 0) {
                TreeNode curr = nodes.poll();
                if (curr.left == null && curr.right == null) {
                    return level;
                }

                if (curr.left != null) {
                    nodes.offer(curr.left);
                }
                if (curr.right != null) {
                    nodes.offer(curr.right);
                }
                size--;
            }
            
            level++;
        }
        
        return level;
    }
}