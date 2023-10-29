class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        recur(arr, n, ans, 0, 0);
        return ans;
    }
    
    private static void recur(ArrayList<Integer> arr, int n, ArrayList<Integer> ans, int sum, int i) {
        if (i == n) {
            ans.add(sum);
            return;
        }
        
        // not pick
        recur(arr, n, ans, sum, i+1);
        
        // pick
        recur(arr, n, ans, sum + arr.get(i), i+1);
    }
}