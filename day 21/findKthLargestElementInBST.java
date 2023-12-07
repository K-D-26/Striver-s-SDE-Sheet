class Solution {
    private int count = 0;
    private int ans = 0;
    
    public int kthLargest(Node root, int k) {
        helper(root, k);
        return ans;
    }
    
    private void helper(Node node, int k) {
        if (node == null) return;
        
        helper(node.right, k);
        count++;
        if (count == k) {
            ans = node.data;
            return;
        }
        helper(node.left, k);
    }
}