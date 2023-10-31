class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> li = new ArrayList<>();
        
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                twoSum(nums, i, li);
            }
        }
        
        return li;
    }
    
    private void twoSum(int[] nums, int i, List<List<Integer>> li) {
        int j = i + 1, k = nums.length - 1;
        
        while (j < k) {
            int sum = nums[i] + nums[j] + nums[k];
            if (sum == 0) {
                li.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
                k--;
                
                while (j < k && nums[j] == nums[j-1]) {
                    j++;
                }
                while (k > j && nums[k] == nums[k+1]) {
                    k--;
                }
            }
            else if (sum > 0) {
                k--;
            }
            else {
                j++;
            }
        }
    }
}