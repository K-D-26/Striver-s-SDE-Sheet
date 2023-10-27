import java.*;
import java.util.*;

public class Solution {
    public static int[] kMaxSumCombination(int []a, int []b, int n, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            pq.offer(Integer.MIN_VALUE);
        }

        for (int aValue : a) {
            for (int bValue : b) {
                int sum = aValue + bValue;
                if (pq.peek() < sum) {
                    pq.poll();
                    pq.offer(sum);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>(k);
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result);
        
        int[] ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}