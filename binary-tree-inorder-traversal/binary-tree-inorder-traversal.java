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
// iterative
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         Stack<TreeNode> stack = new Stack<>();
//         List<Integer> list = new ArrayList<>();
//         TreeNode curr = root;
        
//         while (curr != null || !stack.empty()) {
//             while (curr != null) {
//                 stack.push(curr);
//                 curr = curr.left;
//             }
            
//             curr = stack.pop();
//             list.add(curr.val);
//             curr = curr.right;
//         }
        
//         return list;
//     }
// }

// recursive
class Solution {
    private void helper(List<Integer> list, TreeNode node) {
        if (node == null) return;
        helper(list, node.left);
        list.add(node.val);
        helper(list, node.right);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        
        helper(list, root);
        
        return list;
    }
}