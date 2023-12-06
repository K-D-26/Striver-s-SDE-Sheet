class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        
        TreeNode root = helper(nums, 0, nums.length - 1);
        return root;
    }
    
    private TreeNode helper(int[] nums, int l, int h) {
        if (l > h) return null;
        
        int m = (h - l) / 2 + l;
        TreeNode root = new TreeNode(nums[m]);
        root.left = helper(nums, l, m - 1);
        root.right = helper(nums, m + 1, h);
        
        return root;
    }
}