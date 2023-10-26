class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] bool = new boolean[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            recur(i, nums, ans, curr, bool);
        }
        
        return ans;
    }
    
    private static void recur(int ind, int[] nums, List<List<Integer>> ans, List<Integer> curr, boolean[] bool) {
        if (bool[ind] == false) {
            bool[ind] = true;
            curr.add(nums[ind]);
            
            for (int i = 0; i < bool.length; i++) {
                if (i != ind && bool[i] == false) {
                    recur(i, nums, ans, curr, bool);
                }
            }
            
            bool[ind] = false;
            if (curr.size() == nums.length) {
                ans.add(new ArrayList<>(curr));
            }
            curr.remove(curr.size() - 1);
        }
    }
}