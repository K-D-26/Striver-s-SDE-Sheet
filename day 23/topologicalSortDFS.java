class Solution {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[V];
        int[] vis = new int[V];
        
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }
        
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.peek();
            st.pop();
        }
        
        return ans;
    }
    
    private static void dfs(int i, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[i] = 1;
        for (Integer it : adj.get(i)) {
            if (vis[it] == 0) {
                dfs(it, vis, st, adj);
            }
        }
        
        st.push(i);
    }
}