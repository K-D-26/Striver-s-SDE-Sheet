class Solution {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // This is also known as "Kahn's Algorithm"

        int[] ans = new int[V];
        int[] indegree = new int[V];
        
        for (int i = 0; i < V; i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int k = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            ans[k++] = node;
            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        
        return ans;
    }
}