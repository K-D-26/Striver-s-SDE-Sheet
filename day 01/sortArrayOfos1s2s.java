class Solution {
    public void sortColors(int[] nums) {
        int l = 0, m = 0, r = nums.length - 1;
        
        while (m <= r) {
            if (nums[m] == 0) {
                swap(l, m, nums);
                l++;
                m++;
            }
            else if (nums[m] == 2) {
                swap(r, m, nums);
                r--;
            }
            else {
                m++;
            }
        }
    }
    
    private void swap(int i, int j, int[] a) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}