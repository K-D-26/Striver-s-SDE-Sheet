class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean even;

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);        // max heap
        large = new PriorityQueue<>();                       // min heap
        even = true;
    }
    
    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        }
        else {
            small.offer(num);
            large.offer(small.poll());
        }
        
        even = !even;
    }
    
    public double findMedian() {
        if (even) {
            return (small.peek() + large.peek()) / 2.0;
        }
        else {
            return small.peek();
        }
    }
}