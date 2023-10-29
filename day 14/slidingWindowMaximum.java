class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int ind = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // removing numbers that are out of range k
            if (!dq.isEmpty() && dq.peek() == i-k) {
                dq.poll();
            }
            
            // removing smaller numbers present in range k
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            
            dq.offer(i);
            if (i >= k-1) {
                ans[ind++] = nums[dq.peek()];
            }
        }
        
        return ans;
    }
}