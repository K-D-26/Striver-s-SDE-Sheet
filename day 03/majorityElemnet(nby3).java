class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n1 = -1, n2 = -1, c1 = 0, c2 = 0;
        
        for (int i : nums) {
            if (i == n1) {
                c1++;
            }
            else if (i == n2) {
                c2++;
            }
            else if (c1 == 0) {
                n1 = i;
                c1++;
            }
            else if (c2 == 0) {
                n2 = i;
                c2++;
            }
            else {
                c1--;
                c2--;
            }
        }
        
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n1) {
                c1++;
            }
            else if (nums[i] == n2) {
                c2++;
            }
        }
        
        if (c1 > nums.length/3) {
            ans.add(n1);
        }
        if (c2 > nums.length/3) {
            ans.add(n2);
        }
        
        return ans;
    }
}