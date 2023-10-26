class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 2;
        
        while(low <= high) {
            int mid = (low + high) >> 1;
            
            if(nums[mid] == nums[mid^1]) {      // by doing XOR, we get the previous index i.e. (mid ^ 1) = (mid + 1)
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return nums[low];
    }
}