// leetcode: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

// Method 1:

class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (s.charAt(i) == s.charAt(n-1-j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                }
                else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        
        return n - dp[n][n];
    }
}


// Method 2:

class Solution {
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String t = sb.toString();
        
        int a = s.length();
        int b = a;
        int ans = 0;
        
        // LCS (Tabulation)
        int[][] dp = new int[a+1][b+1];
        for (int i = 0; i <= a; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                
                ans = Math.max(ans, dp[i][j]);
            }
        }
        
        return a - ans;
    }
}


// coding ninja

// Method 1:

public class Solution {
    public static int minCharsforPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int cnt = 0;
        int k = j;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            else {
                i = 0;
                k--;
                j = k;
                cnt++;
            }
        }

        return cnt;
    }
}


// Method 2:

public class Solution {
    public static int minCharsforPalindrome(String str) {
        int n = str.length();
        String reversedStr = new StringBuilder(str).reverse().toString();
        String modifiedStr = str + "$" + reversedStr;
        
        int[] lps = new int[2 * n + 1];
        computeLPS(modifiedStr, lps);
        return n - lps[2 * n];
    }
    
    private static void computeLPS(String str, int[] lps) {
        int n = str.length();
        int len = 0;
        
        int i = 1;
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len != 0) {
                    len = lps[len-1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}