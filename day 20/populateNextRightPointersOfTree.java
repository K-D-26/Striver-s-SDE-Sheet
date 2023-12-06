class Solution {
    public Node connect(Node root) {
        List<List<Node>> list = new ArrayList<>();
        helper(root, list, 0);
        return root;
    }
    
    private void helper(Node node, List<List<Node>> list, int h) {
        if (node == null) return;
        
        if (list.size() <= h) list.add(new ArrayList<>());
        
        helper(node.right, list, h+1);
        helper(node.left, list, h+1);
        
        List<Node> l = list.get(h);
        if (l.size() > 0 && l.get(0) != null) {
            node.next = l.get(0);
        }
        l.add(0, node);
    }
}