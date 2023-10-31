import java.util.*;
import java.io.*;

public class Solution {
    public static int[] missingAndRepeating(ArrayList<Integer> list, int n) {
        long sn = (n * (n+1)) / 2;                  // sum of n numbers
        long s2n = (n * (n+1) * (2*n+1)) / 6;       // sum of squares of n numbers
        long s = 0, s2 = 0;
        for (int i = 0; i < n; i++) {
            s += list.get(i);
            s2 += list.get(i) * list.get(i);
        }

        long val1 = s - sn;         // will store repeating - missing
        long val2 = s2 - s2n;       // will store repeating^2 - missing^2 = (repeating - missing) * (repeating + missing)
        val2 = val2 / val1;         // will update to (repeating + missing)
        long r = (val1 + val2) / 2; 
        long m = r - val1;
        return new int[]{(int)m, (int)r};
    }
}


// Method 2:

import java.util.*;
import java.io.*;

public class Solution {
    public static int[] missingAndRepeating(ArrayList<Integer> list, int n) {
        int[] ans = new int[2];
        boolean[] arr = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (arr[list.get(i)-1] == true) {
                ans[1] = list.get(i);
            }
            arr[i] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!arr[i] == false) {
                ans[0] = i+1;
                break;
            }
        }

        return ans;
    }
}