class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode node, long lb, long ub) {           // lb --> lower bound, ub --> upper bound
        if (node == null) return true;
        if (node.val <= lb || node.val >= ub) return false;
        
        return helper(node.left, lb, node.val) && helper(node.right, node.val, ub);
    }
}