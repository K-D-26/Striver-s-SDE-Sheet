import java.util.* ;
import java.io.*; 

public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        Arrays.fill(ans, Integer.MIN_VALUE);
        left[0] = -1;
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) {
                st.pop();
            }

            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        while (!st.isEmpty()) st.pop();

        right[n-1] = n;
        st.push(n-1);
        for (int i = n-2; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) {
                st.pop();
            }

            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len-1] = Math.max(ans[len-1], a[i]);
        }

        for (int i = n-2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i+1]);
        }

        return ans;
    }
}