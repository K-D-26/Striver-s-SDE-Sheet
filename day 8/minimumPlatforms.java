class Solution {
    static int findPlatform(int arr[], int dep[], int n) {
        int maxPlatforms = 0, currOccupied = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0;
        
        while (i != n) {
            int a = arr[i];
            int d = dep[j];
            
            // train arrived
            if (a <= d) {
                if (currOccupied == maxPlatforms) {
                    maxPlatforms++;
                }
                currOccupied++;
                i++;
            }
            
            // train departured
            if (a > d) {
                currOccupied--;
                j++;
            }
        }
        
        return maxPlatforms;
    }
}