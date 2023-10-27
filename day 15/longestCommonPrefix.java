class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        Arrays.sort(strs);
        String a = strs[0];
        String b = strs[strs.length - 1];
        int c = 0;
        
        while (c < a.length()) {
            if (a.charAt(c) == b.charAt(c)) {
                c++;
            }
            else {
                break;
            }
        }
        
        return c > 0 ? a.substring(0, c) : "";
    }
}