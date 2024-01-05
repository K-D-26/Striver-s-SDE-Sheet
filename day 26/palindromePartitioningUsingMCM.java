class Solution{
    static int palindromicPartition(String s) {
        // Tabulation
		int n = s.length();
		int[] dp = new int[n + 1];
		
		dp[n] = 0;

		for (int i = n - 1; i >= 0; i--) {
			int mini = Integer.MAX_VALUE;
			for (int j = i; j < n; j++) {
				if (isPalindrome(i, j, s)) {
					int cost = 1 + dp[j+1];
					mini = Math.min(mini, cost);
				}
			}

			dp[i] = mini;
		}
		
		return dp[0] - 1;
    }
    
    static boolean isPalindrome(int i, int j, String s) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
			    return false;
			}
			i++;
			j--;
		}
		
		return true;
	}
}