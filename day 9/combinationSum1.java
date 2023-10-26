class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        recur(candidates, ans, new ArrayList<>(), target, 0, 0);
        return ans;
    }
    
    private static void recur(int[] arr, List<List<Integer>> ans, List<Integer> curr, int target, int sum, int i) {
        if (sum > target) return;
        
        if (i == arr.length) {
            if (sum == target) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        
        // take
        curr.add(arr[i]);
        recur(arr, ans, curr, target, sum + arr[i], i);
        
        // not take
        curr.remove(curr.size() - 1);
        recur(arr, ans, curr, target, sum, i+1);
    }
}