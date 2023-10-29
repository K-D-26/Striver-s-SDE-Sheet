// Method 1:

class Solution {
    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        // recursive
        inorder(root);
        return ans;
    }
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        
        inorder(node.left);
        ans.add(node.val);
        inorder(node.right);
    }
}


// Method 2:

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // Iterative
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        while (true) {
            if (root != null) {
                st.push(root);
                root = root.left;           // go to left
            } 
            else {
                if (st.isEmpty()) break;
                
                root = st.peek();
                ans.add(root.val);          // add root
                st.pop();
                root = root.right;          // go to right
            }
        }
        
        return ans;
    }
}