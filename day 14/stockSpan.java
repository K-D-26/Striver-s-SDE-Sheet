// coding ninja

import java.util.*;

public class Solution {
    public static int[] findStockSpans(int []prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0 ; i < n ; i++) {
            while (!st.isEmpty() && prices[st.peek()] < prices[i]) {
                st.pop() ;
            }

            if (st.isEmpty()) {
                ans[i] = i + 1;
            }
            else {
                ans[i] = i - st.peek() ;
            }
            
            st.push(i) ;
        }

        return ans ;
    }
}


// leetcode

class StockSpanner {
    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int ans = 1;
        
        while (!st.isEmpty() && st.peek()[0] <= price) {
            ans += st.pop()[1];
        }
        
        st.push(new int[]{price, ans});
        
        return ans;
    }
}