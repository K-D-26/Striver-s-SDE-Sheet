// GFG:

class Solution {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        // Using DFS:
        
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, adj, color) == false) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static boolean dfs(int s, int col, ArrayList<ArrayList<Integer>>adj, int[] color) {
        color[s] = col;
        
        for (int i : adj.get(s)) {
            if (color[i] == -1) {
                if (dfs(i, 1-col, adj, color) == false) {
                    return false;
                }
            }
            else if (color[i] == col)
                return false;
        }
        
        return true;
    }
}


// Leetcode:

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (dfs(i, graph, color, 0) == false) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean dfs(int i, int[][] graph, int[] color, int col) {
        color[i] = col;
        for (int it : graph[i]) {
            if (color[it] == -1) {
                if (dfs(it, graph, color, 1-col) == false) {
                    return false;
                }
            }
            else if (color[it] == col) {
                return false;
            }
        }
        
        return true;
    }
}