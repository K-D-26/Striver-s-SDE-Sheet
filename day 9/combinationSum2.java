class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        recur(candidates, ans, new ArrayList<>(), target, 0);
        return ans;
    }
    
    private static void recur(int[] arr, List<List<Integer>> ans, List<Integer> curr, int target, int ind) {
        if (target == 0) {
            if (!ans.contains(curr)) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        
        if (ind == arr.length) return;
        
        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i-1]) continue;
            
            if (arr[i] > target) break;
            
            // take
            curr.add(arr[i]);
            recur(arr, ans, curr, target - arr[i], i+1);

            // not take
            curr.remove(curr.size() - 1);
        }
    }
}