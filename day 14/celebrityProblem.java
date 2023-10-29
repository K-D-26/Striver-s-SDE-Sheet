import java.util.* ;
import java.io.*; 
	
public class Solution {
	public static int findCelebrity(int n) {
        Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			st.push(i);
		}

		while (st.size() > 1) {
			int a = st.pop();
			int b = st.pop();
			
			if (Runner.knows(a, b)) {
				st.push(b);
			}
			else {
				st.push(a);
			}
		}

		int ans = st.pop();
		 for (int i = 0; i < n; i++) {
            if (i == ans) {
                continue;
			}
            if (Runner.knows(ans, i)) {
                return -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == ans) {
                continue;
			}
            if (!Runner.knows(i, ans)) {
                return -1;
            }
        }

		return ans;
    }
}