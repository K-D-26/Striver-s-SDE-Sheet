class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        recur(s, ans, curr, 0);
        return ans;
    }
    
    private static void recur(String s, List<List<String>> ans, List<String> curr, int ind) {
        if (ind == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = ind; i < s.length(); i++) {
            if (isPalindrome(s.substring(ind, i+1))) {
                curr.add(s.substring(ind, i+1));
                recur(s, ans, curr, i+1);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        
        return true;
    } 
}