import java.util.* ;
import java.io.*; 

public class Solution {
    static int[] minHeap(int n, int[][] q) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (q[i][0] == 0) {
                pq.offer(q[i][1]);
            }
            else {
                ans.add(pq.peek());
                pq.poll();
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        
        return res;
    }
}