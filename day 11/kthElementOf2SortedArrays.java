public class Solution {
    public static int ninjaAndLadoos(int arr1[], int arr2[], int m, int n, int k) {
        if (m > n) {
            return ninjaAndLadoos(arr2, arr1, n, m, k);
        }
        
        int low = Math.max(0, k-n), high = Math.min(k, m);
        
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = k - mid1;
            
            int left1 = mid1 == 0 ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int left2 = mid2 == 0 ? Integer.MIN_VALUE : arr2[mid2 - 1];
            
            int right1 = mid1 == m ? Integer.MAX_VALUE : arr1[mid1];
            int right2 = mid2 == n ? Integer.MAX_VALUE : arr2[mid2];
            
            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2);
            }
            else if (left1 > right2) {
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1;
            }
        }
        
        return 1;
    }
}