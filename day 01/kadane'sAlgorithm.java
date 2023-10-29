// Method 1:

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}


// Method 2:

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int currMax = 0;

        for (int i = 0; i < nums.length; i++) {
            currMax += nums[i];
            if (currMax > maxSoFar) {
                maxSoFar = currMax;
            }

            if (currMax < 0) {
                currMax = 0;
            }
        }
        return maxSoFar;
    }
}