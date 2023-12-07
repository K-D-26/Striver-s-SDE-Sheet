public class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();
    boolean reverse = true;             // reverse == true --> before, false --> next
    
    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }
    
    private void pushAll(TreeNode node) {
        while (node != null) {
            st.push(node);
            if (reverse == true) {
                node = node.right;
            }
            else {
                node = node.left;
            }
        }
    }
    
    public int next() {
        TreeNode temp = st.pop();
        if (reverse == false) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.val;
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);
        
        int i = l.next();
        int j = r.next();
        while (i < j) {
            if (i + j == k) return true;
            else if (i + j < k) i = l.next();
            else j = r.next();
        }
        
        return false;
    }
}