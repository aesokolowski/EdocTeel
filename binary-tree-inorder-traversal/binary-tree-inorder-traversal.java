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
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<TreeNode> visited = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        
        if (root == null) return inOrder;
        
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            TreeNode left = current.left,
                     right = current.right;
            
            if (left != null && !visited.contains(left)) {
                stack.push(current);
                stack.push(left);
            } else {
                if (!visited.contains(current)) {
                    inOrder.add(current.val);
                    visited.add(current);
                }
                
                if (right != null && !visited.contains(right)) {
                    stack.push(current);
                    stack.push(right);
                }
            }
        }
        
        return inOrder;
    }
}