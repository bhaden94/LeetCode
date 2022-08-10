/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        
        Queue<Node> nodes = new LinkedList<>();
        root.next = null;
        if (root.left != null) {
            nodes.offer(root.left);
        }
        if (root.right != null) {
            nodes.offer(root.right);
        }
        
        while (!nodes.isEmpty()) {
            Node curr = nodes.poll();
            int size = nodes.size();
            if (curr.left != null) {
                nodes.offer(curr.left);
            }
            if (curr.right != null) {
                nodes.offer(curr.right);
            }
            while (size > 0) {
                Node next = nodes.poll();
                if (next.left != null) {
                    nodes.offer(next.left);
                }
                if (next.right != null) {
                    nodes.offer(next.right);
                }
                curr.next = next;
                curr = next;
                size--;
            }
            curr.next = null;
        }
        
        return root;
    }
}