// The Nth root of M definitely lies between 0 to m/n. So we apply a binary search in this range to find the root.

public class Solution {
    public static int NthRoot(int n, int m) {
        int i = 0, j = m/n;
        
        while (i <= j) {
            int mid = i + ((j - i) / 2);
            if (Math.pow(mid, n) == m) {
                return mid;
            }
            else if (Math.pow(mid, n) > m) {
                j = mid - 1;
            }
            else {
                i = mid + 1;
            }
        }

        return -1;
    }
}