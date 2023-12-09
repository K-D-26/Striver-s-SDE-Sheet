// Method 1:

class Solution {
    public int maxProduct(int[] nums) {
        int p1 = nums[0], p2 = nums[0], ans = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(nums[i], Math.max(nums[i]*p1, nums[i]*p2));
            p1 = Math.min(nums[i], Math.min(nums[i]*p1, nums[i]*p2));
            p2 = temp;
            ans = Math.max(ans, p2);
        }
        
        return ans;
    }
}


// Method 2:

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int l = nums[0], r = nums[n-1];
        int pro = 1;
        boolean hasZero = false;
        
        for (int i = 0; i < n; i++) {
            pro *= nums[i];
            if (nums[i] == 0) {
                hasZero = true;
                pro = 1;
                continue;
            }
            l = Math.max(l, pro);
        }
        
        pro = 1;
        for (int j = n-1; j >= 0; j--) {
            pro *= nums[j];
            if (nums[j] == 0) {
                hasZero = true;
                pro = 1;
                continue;
            }
            r = Math.max(r, pro);
        }
        
        if (hasZero) {
            return Math.max(Math.max(l, r), 0);
        }

        return Math.max(l, r);
    }
}


// Method 3:

class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int max = nums[0];
        int min = nums[0];

        if (max == 0) max = 1;
        if (min == 0) min = 1;
        
        for (int i = 1; i < nums.length; i++) {
            int pro1 = max*nums[i];
            int pro2 = min*nums[i];

            max = Math.max(nums[i], Math.max(pro1, pro2));
            min = Math.min(nums[i], Math.min(pro1, pro2));
            maxSoFar = Math.max(maxSoFar, max);
            
            if (max == 0) max = 1;
            if (min == 0) min = 1;
        }

        return maxSoFar;
    }
}