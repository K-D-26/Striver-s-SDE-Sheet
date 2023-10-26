import java.util.* ;
import java.io.*; 

public class Solution {
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        long low = Long.MIN_VALUE;
        long high = 0;

        for (int val : time) {
            low = Math.max(val, low);
            high += val;
        }

        long ans = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(mid, time, n)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isPossible(long target, int[] arr, int n) {
        int days = 1;
        long sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum + arr[i] <= target) {
                sum += arr[i];
            }
            else {
                days += 1;
                if (arr[i] > target) return false;
                sum = arr[i];
            }
        }
        
        return (days <= n) ? true : false;
    }
}