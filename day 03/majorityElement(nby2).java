class Solution {
    public int majorityElement(int[] nums) {
        // Moore voting algo
        int cnt = 0, ans = 0;
        for(int i : nums) {
            if(cnt == 0) {
                ans = i;
            }
            if(i == ans) {
                cnt++;
            }
            else {
                cnt--;
            }
        }
        
        return ans;
    }
}