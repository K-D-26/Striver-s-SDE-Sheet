class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    
    private TreeNode helper(int[] pre, int upperBound, int[] a) {
        if (a[0] == pre.length || pre[a[0]] > upperBound) return null;
        
        TreeNode root = new TreeNode(pre[a[0]++]);
        root.left = helper(pre, root.val, a);
        root.right = helper(pre, upperBound, a);
        
        return root;
    }
}