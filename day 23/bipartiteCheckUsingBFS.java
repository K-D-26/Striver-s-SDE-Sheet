// GFG:

class Solution {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (check(i, V, adj, color) == false) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static boolean check(int s, int V, ArrayList<ArrayList<Integer>>adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        color[s] = 0;
        
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            
            for (int i : adj.get(node)) {
                if (color[i] == -1) {
                    color[i] = 1 - color[node];
                    q.add(i);
                }
                else if (color[i] == color[node])
                    return false;
            }
        }
        
        return true;
    }
}