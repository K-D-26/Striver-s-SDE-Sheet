class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] arr = new boolean[128];
        int ans = 0;

        for(int i=0, j=0; i<s.length() && j<s.length(); ) {
            if(!arr[s.charAt(j)]) {
                arr[s.charAt(j)] = true;
                j++;
            }
            else {
                while(i<j && s.charAt(i) != s.charAt(j)) {
                    arr[s.charAt(i)] = false;
                    i++;
                }
                arr[s.charAt(i)] = false;
                i++;
            }
            ans = Math.max(ans, j-i);
        }
        
        return ans;
    }
}