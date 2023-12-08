class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int n : nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        }
        else if (pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        
        return pq.peek();
    }
}