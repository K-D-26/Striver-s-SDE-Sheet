class Solution {
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (x, y) -> y.profit - x.profit);        // sorted according to the profit in decreasing order
        
        int maxi = 0;
        for (Job j : arr) {
            if (j.deadline > maxi) {
                maxi = j.deadline;
            }
        }
        
        int jobsDone = 0;
        int maxProfit = 0;
        int[] jobs = new int[maxi];
        
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline - 1; j >= 0; j--) {
                if (jobs[j] == 0) {
                    jobs[j] = arr[i].id;
                    jobsDone++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }
        
        int[] ans = new int[2];
        ans[0] = jobsDone;
        ans[1] = maxProfit;
        
        return ans;
    }
}