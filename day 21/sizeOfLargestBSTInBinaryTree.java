// Laregest BST(GFG):

class NodeValue {
    public int minNode, maxNode, maxSize;
    
    public NodeValue(int min, int max, int size) {
        this.minNode = min;
        this.maxNode = max;
        this.maxSize = size;
    }
}

class Solution {
    private static NodeValue helper(Node node) {
        if(node == null) return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        
        NodeValue left = helper(node.left);
        NodeValue right = helper(node.right);
        
        // if current node's value is greater than the max value in left sub-tree and 
        // smaller than the min value in right sub-tree, it is a valid BST
        if(left.maxNode < node.data && node.data < right.minNode) {
            return new NodeValue(Math.min(node.data, left.minNode), Math.max(node.data, right.maxNode), 1 + left.maxSize + right.maxSize);
        }
        // else return NodeValue as (Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize)) 
        // so the parent can never be a valid BST.
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
    
    static int largestBst(Node root) {
        return helper(root).maxSize;
    }
}


// Maximum Sum BST in Binary Tree (Leetcode):
// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

class Solution {
    private int maxSum = 0;
    
    public int maxSumBST(TreeNode root) {
        postOrderTraversal(root);
        return maxSum;
    }
    
    private int[] postOrderTraversal(TreeNode node) {
        if (node == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        
        int[] left = postOrderTraversal(node.left);
        int[] right = postOrderTraversal(node.right);
        
        if (left == null || right == null || node.val <= left[1] || node.val >= right[0]) return null;
        
        int sum = node.val + left[2] + right[2];
        maxSum = Math.max(maxSum, sum);
        int min = Math.min(node.val, left[0]);
        int max = Math.max(node.val, right[1]);
        return new int[]{min, max, sum};
    }
}