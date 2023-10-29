// Method 1:

class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int i : nums) {
            set.add(i);
        }
        
        for(int n : nums) {
            int left = n - 1;
            int right = n + 1;

            // checking on the left upto which number are present in the set
            while(set.remove(left)) {
                left--;
            }

            // checking on the right upto which number are present in the set
            while(set.remove(right)) {
                right++;
            }

            ans = Math.max(ans, right - left - 1);
            
            if(set.isEmpty()) return ans;
        }
        
        return ans;
    }
}


// Method 2:

class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) {
            if(!map.containsKey(i)) {
                int left = (map.containsKey(i-1)) ? map.get(i-1) : 0;
                int right = (map.containsKey(i+1)) ? map.get(i+1) : 0;
                int tot = left + right + 1;
                map.put(i, tot);
                
                ans = Math.max(ans, tot);
                
                // update the length of the boundaries
                map.put(i-left, tot);
                map.put(i+right, tot);
            }
            
            else {
                continue;
            }
        }
        
        return ans;
    }
}