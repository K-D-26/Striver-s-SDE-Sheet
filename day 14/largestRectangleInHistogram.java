// Method 1:

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            
            if (st.isEmpty()) {
                leftMin[i] = 0;
            }
            else {
                leftMin[i] = st.peek() + 1;
            }
            st.push(i);
        }
        
        while (!st.isEmpty()) st.pop();
        
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            
            if (st.isEmpty()) {
                rightMin[i] = n-1;
            }
            else {
                rightMin[i] = st.peek() - 1;
            }
            st.push(i);
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (rightMin[i] - leftMin[i] + 1));
        }
        
        return ans;
    }
}


// Method 2:

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.peek()];
                st.pop();
                int width; 
                
                if (st.isEmpty()) {
                    width = i;
                }
                else {
                    width = i - st.peek() - 1;
                }
                
                ans = Math.max(ans, height * width);
            }
            
            st.push(i);
        }
        
        return ans;
    }
}