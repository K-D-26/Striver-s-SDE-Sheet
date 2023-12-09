class Solution {
	public int maxSumIS(int arr[], int n) {  
	    int[] dp = new int[n + 1];
	    int max = Integer.MIN_VALUE;
	    
	    for (int i = 1; i <= n; i++) {
	        dp[i] = arr[i-1];
	        for (int j = i-1; j > 0; j--) {
	            int val = 0;
	            if (arr[i-1] > arr[j-1]) {
	                val = arr[i-1] + dp[j];
	            }
	            dp[i] = Math.max(dp[i], val);
	        }
	    }
	    
	    for (int num : dp) {
	        if (num > max) {
	            max = num;
	        }
	    }
	    
	    return max;
	}  
}