class Solution {
    static int eggDrop(int n, int k) {
	    int[][] dp = new int[n + 1][k + 1];
        for (int j = 1; j < k + 1; j++) {
            dp[1][j] = j;
        }
        
        for (int i = 2; i < n + 1; i++) {           // i eggs
            for(int j = 1; j < k + 1; j++) {        // jth floor
                int min = Integer.MAX_VALUE;
                
                for (int mj = j - 1, pj = 0; mj >= 0; pj++, mj--) {
                    min = Math.min(min, 1 + Math.max(dp[i][mj], dp[i-1][pj]));       
                }
                
                dp[i][j] = min;
            }
        }
        
        return dp[n][k];
	}
}