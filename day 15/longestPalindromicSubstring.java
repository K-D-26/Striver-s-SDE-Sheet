class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        
        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i);
            String s2 = extend(s, i, i+1);
            if (s1.length() > max.length()) {
                max = s1;
            }
            if (s2.length() > max.length()) {
                max = s2;
            }
        }
        
        return max;        
    }
    
    private String extend(String s, int i, int j) {
        for (; i >= 0 && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
        }
        
        return s.substring(i+1, j);
    }
}