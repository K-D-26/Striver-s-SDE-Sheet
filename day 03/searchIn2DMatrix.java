class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length-1;
        int k;
        
        while(i<matrix.length && j>=0) {
            k = matrix[i][j];
            if(k == target) {
                return true;
            }
            else if(target < k) {
                j--;
            }
            else {
                i++;
            }
        }

        return false;


        // int r = matrix.length, c = matrix[0].length;
        // int l = 0, h = r*c - 1;
        
        // while(l <= h) {
        //     int m = (l+h)/2;
        //     if(matrix[m/c][m%c] == target) {
        //         return true;
        //     }
        //     else if(matrix[m/c][m%c] < target) {
        //         l = m+1;
        //     }
        //     else {
        //         h = m-1;
        //     }
        // }

        // return false;
    }
}