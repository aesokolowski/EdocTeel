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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        
        return recurse(root, targetSum, 0, new ArrayList<>(), new ArrayList<>());
    }
    
    private List<List<Integer>> recurse(TreeNode current, int targetSum, int sum, List<Integer> path,
            List<List<Integer>> matches)
    {
        Boolean leftNull = true,
                rightNull = true;
        TreeNode left = current.left,
                 right = current.right;
        Integer value = current.val;
        
        path.add(value);
        sum += value;
        if (left != null) {
            matches = recurse(left, targetSum, sum, path, matches);
            leftNull = false;
        }
        if (right != null) {
            matches = recurse(right, targetSum, sum, path, matches);
            rightNull = false;
        }
        if (rightNull && leftNull && sum == targetSum) {
            List<Integer> match = new ArrayList<>(path);
            matches.add(match);
        }
        
        /* DEBUG:
        System.out.println("value: " + value +
                           "\ntargetSum: " + targetSum +
                           "\nsum: " + sum +
                           "\npath.toString(): " + path.toString() +
                           "\nmatches.toString(): " + matches.toString() +
                           "\n----------------------------------");
        */ //END DEBUG        
        
        path.remove(path.size() - 1);
        return matches;
    }
}