// Method 1 (Using 2 stacks):

class MyQueue {
    private Stack<Integer> input, output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if (!output.isEmpty()) return output.pop();
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
        return output.pop();
    }
    
    public int peek() {
        if (!output.isEmpty()) return output.peek();
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
        return output.peek();
    }
    
    public boolean empty() {
        if (!output.isEmpty()) return false;
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
        return output.isEmpty();
    }
}


// Method 2 (Using only 1 stack):

class MyQueue {
    private Stack<Integer> st;

    public MyQueue() {
        st = new Stack<>();
    }
    
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }
        
        temp.push(x);
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }
    
    public int pop() {
        return st.pop();
    }
    
    public int peek() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}