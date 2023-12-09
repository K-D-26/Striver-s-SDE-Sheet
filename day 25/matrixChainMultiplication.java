class Solution{
    static int matrixMultiplication(int n, int arr[]) {
        int[][] dp = new int[n][n];
		for (int i = 1; i < n; i++) {
			dp[i][i] = 0;
		}
		
		for (int i = n-1; i > 0; i--) {
			for (int j = i+1; j < n; j++) {
				int min = Integer.MAX_VALUE;
				for (int k=i; k<j; k++) {
					int steps = arr[i-1]*arr[j]*arr[k] + dp[i][k] + dp[k+1][j];
					if (steps < min) {
						min = steps;
					}
				}
				dp[i][j] = min;
			}
		}
		
		return dp[1][n-1];
    }
}