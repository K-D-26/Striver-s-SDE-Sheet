class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        int i = 0;
        
        while (pq.size() != k) {
            pq.offer(nums[i++]);
        }
        
        while (i != nums.length) {
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
            
            i++;
        }
        
        return pq.peek();
    }
}