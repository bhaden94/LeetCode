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

// Recursion
// class Solution {
//     private boolean helper(TreeNode left, TreeNode right) {
//         if (left == null && right == null) return true;
//         if (left != null && right != null && left.val == right.val) {
//             return (helper(left.left, right.right) &&
//                     helper(left.right, right.left));
//         }
//         return false;
//     }
    
//     public boolean isSymmetric(TreeNode root) {
//         if (root == null) return false;
//         return helper(root, root);
//     }
// }

// Iterative
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        
        while (!q.isEmpty()) {
            TreeNode left = q.remove();
            TreeNode right = q.remove();
            
            if (left == null && right == null) continue;
            
            // if one null
            if (left == null && right != null ||
               left != null && right == null) {
                return false;
            }
                
            // if don't equal
            if (left.val != right.val) return false;
            
            // add to queue
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        
        return true;
    }
}