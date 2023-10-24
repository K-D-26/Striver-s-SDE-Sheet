class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length < 2) return;
        
        int ind1 = nums.length - 2;
        while(ind1 >= 0 && nums[ind1] >= nums[ind1+1]) {
            ind1--;
        }
        
        if(ind1 >= 0) {
            int ind2 = nums.length - 1;
            while(nums[ind2] <= nums[ind1]) {
                ind2--;
            }
            swap(ind1, ind2, nums);
        }
        reverse(ind1+1, nums.length-1, nums);
        return;
    }
    
    private void swap(int i, int j, int[] a) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    private void reverse(int i, int j, int[] a) {
        while(i < j) {
            swap(i++, j--, a);
        }
    }
}