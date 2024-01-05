// Method 1:

class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (String str: dict) {
                if (str.length() <= i) {
                    if (dp[i - str.length()]) {
                        if (s.substring(i-str.length(), i).equals(str)) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[s.length()];
    }
}


// Method 2:

class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}