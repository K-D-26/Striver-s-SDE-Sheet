class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        long ans = 0;
        
        int i = 0;
        boolean flag;       // false if '-' else true
        
        if (s.length() == 0) return (int)ans;
        
        if (s.charAt(i) == '-') {
            flag = false;
            i++;
        }
        else if (s.charAt(i) == '+') {
            flag = true;
            i++;
        }
        else {
            flag = true;
        }
        
        if (i == s.length()) return (int)ans;
        
        for (; i < s.length(); i++) {
            if (s.charAt(i) == ' ' || (s.charAt(i) < '0' || s.charAt(i) > '9')) {
                break;
            }
            ans = ans * 10 + (s.charAt(i) - '0');
            if (ans > Integer.MAX_VALUE) {
                break;
            }
        }
        
        if (ans == Integer.MAX_VALUE) {
            return (flag == false) ? Integer.MIN_VALUE + 1 : (int)ans;
        }
        
        if (ans > Integer.MAX_VALUE) {
            ans = Integer.MAX_VALUE;
        }
        
        if (flag == false) {
            ans = (ans == Integer.MAX_VALUE) ? Integer.MIN_VALUE : ans * -1;
        }
        
        return (int)ans;
    }
}