class Solution {
    public static int floor(Node root, int x) {
        if (root == null) return -1;
        
        int[] a = {-1};
        helper(root, x, a);
        return a[0];
    }
    
    private static void helper(Node node, int x, int[] a) {
        if (node == null) return;
        
        if (node.data == x) {
            a[0] = node.data;
            return;
        }
        
        if (node.data < x) {
            a[0] = node.data;
            helper(node.right, x, a);
        }
        else {
            helper(node.left, x, a);
        }
    }
}