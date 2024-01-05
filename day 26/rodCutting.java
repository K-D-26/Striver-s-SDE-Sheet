// CodingNinja - Rod Cutting:

import java.util.*;

class Solution {
	public static int cutRod(int p[], int n) {
		// Tabulation (space optimised)
		int[] prev = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			prev[i] = i * p[0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= n; j++) {
				int notTake = prev[j];
				int take = Integer.MIN_VALUE;
				int rodLength = i+1;	
				if (rodLength <= j) {
					take = p[i] + prev[j - rodLength];
				}

				prev[j] = Math.max(take, notTake);
			}
		}	

		return prev[n];
	}
}


// LeetCode - Minimum cost to cut a stick:

class Solution {
    public int minCost(int n, int[] cuts) {
        // Tabulation
        int c = cuts.length;
        int[] arr = new int[c + 2];
        arr[0] = 0;
        arr[c+1] = n;
        
        for (int i=1; i<=c; i++) {
            arr[i] = cuts[i-1];
        }
        
        Arrays.sort(arr);
        int[][] dp = new int[c+2][c+2];
        
        for (int i = c; i > 0; i--) {
            for (int j = 1; j <= c; j++) {
                // Base case
                if (i > j) continue;
                
                // recursion logic
                int mini = Integer.MAX_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int cost = arr[j+1] - arr[i-1] + dp[i][ind-1] + dp[ind+1][j];
                    mini = Math.min(mini, cost);
                }
                dp[i][j] = mini;
            }
        }
        
        return dp[1][c];
    }
}