class Solution {
    public int minDistance(String s, String t) {
        int m = s.length(), n = t.length();
        int[] prev = new int[n+1];

        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }
        
        for (int i = 1; i <= m; i++) {
            int[] curr = new int[n+1];
            curr[0] = i;
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    curr[j] = prev[j-1];
                }
                else {
                    curr[j] = Math.min((Math.min((1 + curr[j-1]), (1 + prev[j]))), (1 + prev[j-1]));
                }
            }
            prev = curr;
        }

        return prev[n];
    }
}