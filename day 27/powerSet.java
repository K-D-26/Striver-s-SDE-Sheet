// Method 1:

class Solution {
    public List<String> AllPossibleStrings(String s) {
        List<String> ans = new ArrayList<>();
        findSubsets(0, s, "", ans);
        Collections.sort(ans);
        return ans;
    }
    
    private void findSubsets(int ind, String s, String t, List<String> ans) {
        if (ind == s.length()) {
            if (t != "") {
                ans.add(t);
            }
            return;
        }
        
        // take
        findSubsets(ind+1, s, t + s.charAt(ind), ans);
        // not take
        findSubsets(ind+1, s, t, ans);
    }
}


// Method 2:

class Solution {
    public List<String> AllPossibleStrings(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        
        for (int num = 0; num < (1 << n); num++) {
            String t = "";
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0) {
                    t += s.charAt(i);
                }
            }
            
            if (t.length() > 0) {
                ans.add(t);
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}