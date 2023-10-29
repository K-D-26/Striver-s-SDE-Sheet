class Pair {
    int top;
    int mini;
    public Pair(int a, int b) {
        this.top = a;
        this.mini = b;
    }
}

class MinStack {
    Stack<Pair> st;
    int min;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if (st.isEmpty()) {
            min = val;
        }
        else {
            min = Math.min(val, st.peek().mini);
        }
        
        st.push(new Pair(val, min));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().top;
    }
    
    public int getMin() {
        return st.peek().mini;
    }
}