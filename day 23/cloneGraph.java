class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Node copy = new Node(node.val);
        Node[] vis = new Node[101];
        Arrays.fill(vis, null);
        dfs(node, copy, vis);
        
        return copy;
    }
    
    private void dfs(Node node, Node copy, Node[] vis) {
        vis[copy.val] = copy;
        for (Node n : node.neighbors) {
            if (vis[n.val] == null) {
                Node newNode = new Node(n.val);
                copy.neighbors.add(newNode);
                dfs(n, newNode, vis);
            }
            else {
                copy.neighbors.add(vis[n.val]);
            }
        }
    }
}