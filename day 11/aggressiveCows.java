import java.util.*;

public class Solution {
    public static int aggressiveCows(int []stalls, int cows) {
        int n = stalls.length;
        Arrays.sort(stalls);

        int low = 1, high = stalls[n-1] - stalls[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canBePlaced(stalls, mid, cows)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return high;
    }

    private static boolean canBePlaced(int[] stalls, int dist, int cows) {
        int n = stalls.length;
        int cntCows = 1;
        int last = stalls[0];

        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= dist) {
                cntCows++;
                last = stalls[i];
            }

            if (cntCows >= cows) return true;
        }

        return false;
    }
}