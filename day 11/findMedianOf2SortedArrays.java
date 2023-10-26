// Metod 1:

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int i = 0, j = 0;
        int n = n1 + n2;
        
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int ind1Ele = Integer.MIN_VALUE, ind2Ele = Integer.MIN_VALUE;
        int cnt = 0;
        
        while (i < n1 && j < n2 && (ind1Ele == Integer.MIN_VALUE || ind2Ele == Integer.MIN_VALUE)) {
            if (nums1[i] <= nums2[j]) {
                if(cnt == ind1) ind1Ele = nums1[i];
                if(cnt == ind2) ind2Ele = nums1[i];
                i++;
            }
            else {
                if(cnt == ind1) ind1Ele = nums2[j];
                if(cnt == ind2) ind2Ele = nums2[j];
                j++;
            }
            cnt++;
        }
        
        while (i < n1 && (ind1Ele == Integer.MIN_VALUE || ind2Ele == Integer.MIN_VALUE)) {
            if (cnt == ind1) ind1Ele = nums1[i];
            if (cnt == ind2) ind2Ele = nums1[i];
            cnt++;
            i++;
        }
        
        while (j < n2 && (ind1Ele == Integer.MIN_VALUE || ind2Ele == Integer.MIN_VALUE)) {
            if (cnt == ind1) ind1Ele = nums2[j];
            if (cnt == ind2) ind2Ele = nums2[j];
            cnt++;
            j++;
        }
        
        if (n % 2 == 1) {
            return ind2Ele;
        }
        
        return (double)((double)(ind1Ele + ind2Ele)) / 2.0;
    }
}


// Method 2 (Optimized):

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        
        int low = 0, high = n1;
        int left = (n1 + n2 + 1) / 2;
        int n = n1 + n2;
        
        while(low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            
            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];
            
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];
            
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1;
            }
        }
        
        return 0;
    }
}