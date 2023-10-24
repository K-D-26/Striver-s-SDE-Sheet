class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> prev = null, curr = null;
        
        for(int i=0; i<n; i++) {
            curr = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if(j == 0 || j == i) {
                    curr.add(1);
                }
                else {
                    curr.add(prev.get(j) + prev.get(j-1));
                }
            }
            prev = curr;
            ans.add(curr);
        }
        
        return ans;
    }
}