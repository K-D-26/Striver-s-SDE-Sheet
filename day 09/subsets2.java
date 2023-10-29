class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        recur(nums, ans, new ArrayList<>(), 0);
        return ans;
    }
    
    private static void recur(int[] nums, List<List<Integer>> ans, List<Integer> curr, int i) {
        if (i >= nums.length) {
            if (!ans.contains(curr)) {
                ans.add(new ArrayList<>(curr));
            }
            curr = new ArrayList<Integer>();
            return;
        }
        
        // pick
        curr.add(nums[i]);
        recur(nums, ans, curr, i+1);
        
        // not pick
        curr.remove(curr.size()-1);
        recur(nums, ans, curr, i+1);
    }
}