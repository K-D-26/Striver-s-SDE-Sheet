class Solution {
    void mirror(Node node) {
        convert(node);
    }
    
    void convert(Node node) {
        if (node == null) return;
        
        Node left = node.left;
        node.left = node.right;
        node.right = left;
        
        convert(node.left);
        convert(node.right);
    }
}