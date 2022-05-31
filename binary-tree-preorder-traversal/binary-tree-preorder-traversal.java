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
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         if (root == null) return new ArrayList<Integer>();
//         Stack<TreeNode> stack = new Stack<>();
//         List<Integer> tree = new ArrayList<>();
        
//         stack.push(root);
        
//         while (!stack.empty()) {
//             TreeNode curr = stack.pop();
//             tree.add(curr.val);
            
//             if (curr.right != null) {
//                 stack.push(curr.right);
//             }
//             if (curr.left != null) {
//                 stack.push(curr.left);
//             }
//         }
        
//         return tree;
//     }
// }

// recursive
class Solution {
    
    private void helper(List<Integer> list, TreeNode node) {
        if (node == null) return;
        list.add(node.val);
        helper(list, node.left);
        helper(list, node.right);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) { 
        List<Integer> list = new ArrayList<>();
        if (root == null) { return list; }
        
        helper(list, root);
        
        return list;
    }
}
