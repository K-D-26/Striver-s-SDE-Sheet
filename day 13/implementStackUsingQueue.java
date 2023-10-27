class MyStack {
    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.offer(x);
        for (int i = 1; i < q.size(); i++) {
            q.offer(q.remove());
        }
    }
    
    public int pop() {
        return q.isEmpty() ? -1 : q.remove();
    }
    
    public int top() {
        return q.isEmpty() ? -1 : q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}