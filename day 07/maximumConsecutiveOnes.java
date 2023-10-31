class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones = 0, max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, ones);
                ones = 0;
            }
            else {
                ones++;
            }
        }
        
        return Math.max(max, ones);
    }
}