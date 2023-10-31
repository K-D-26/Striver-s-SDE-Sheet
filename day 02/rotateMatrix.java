class Solution {
    public void rotate(int[][] matrix) {
        // transpose
        for (int i = 0; i < matrix.length; i++) {
            for(int j = i; j < matrix[0].length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        
        // reverse all rows
        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }
    }
    
    private static void reverse(int[] a) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
            l++;
            r--;
        }
    }
}