class ArrayListComparator implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        // Compare the first elements of the two lists
        return list1.get(0).compareTo(list2.get(0));
    }
}

class Solution { 
    // Tarjan's Algorithm (to get the scc elements)
    public ArrayList<ArrayList<Integer>> tarjans(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, st);
            }
        }
        
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            vis[i] = false;
            adjT.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < n; i++) {
            for (Integer it : adj.get(i)) {
                adjT.get(it).add(i);            // reversing the edges
            }
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            int node = st.pop();
            if (!vis[node]) {
                ArrayList<Integer> temp = new ArrayList<>();
                dfsN(node, vis, adjT, temp);
                Collections.sort(temp);
                ans.add(temp);
            }
        }
        
        Collections.sort(ans, new ArrayListComparator());
        return ans;
    }
    
    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, st);
            }
        }
        
        st.push(node);
    }
    
    private void dfsN(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> temp) {
        vis[node] = true;
        temp.add(node);
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfsN(it, vis, adj, temp);
            }
        }
    }
}