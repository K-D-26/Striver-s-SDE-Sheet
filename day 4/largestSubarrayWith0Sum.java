class GfG {
    int maxLen(int arr[], int n) {
        // Optimal solution if array contains negative values:
        
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        
        for(int i=0; i<n; i++) {
            sum += arr[i];
            if(sum == 0) {
                maxLen = i + 1;
            }
            else {
                if(preSumMap.get(sum) != null) {
                    maxLen = Math.max(maxLen, i - preSumMap.get(sum));
                }
                else {
                    preSumMap.put(sum, i);
                }
            }
        }
        
        return maxLen;
    }
}