class Solution {
    static int knapSack(int w, int wt[], int val[], int n) {
        int[][] dp = new int[n+1][w+1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else {
                    if (j >= wt[i-1]) {         // it is [i-1] because our dp array is of n+1 length
                        dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]]);
                    }
                    else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        
        return dp[n][w];
    } 
}