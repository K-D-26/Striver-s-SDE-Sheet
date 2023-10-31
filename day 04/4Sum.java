class Solution {
    int len;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return ksum(nums, target, 4, 0);
    }
    
    private List<List<Integer>> ksum(int[] nums, long target, int k, int ind) {
        List<List<Integer>> res = new ArrayList<>();
        if (ind >= len) {
            return res;
        }
        
        if (k == 2) {
            int i = ind, j = len - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    res.add(temp);
                    i++;
                    j--;

                    while (i < j && nums[i] == nums[i-1]) {
                        i++;
                    }
                    
                    while (j > i && nums[j] == nums[j+1]) {
                        j--;
                    }
                }
                else if (nums[i] + nums[j] > target) {
                    j--;
                }
                else {
                    i++;
                }
            }
        }
        else {
            for (int i = ind; i < len - k + 1; i++) {
                List<List<Integer>> temp = ksum(nums, target-nums[i], k-1, i+1);
                if (temp != null) {
                    // add previous results
                    for (List<Integer> l : temp) {
                        l.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                
                while (i < len-1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
        
        return res;
    }
}