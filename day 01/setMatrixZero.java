// Method 1:

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row = false, col = false;
        int r = matrix.length;
        int c = matrix[0].length;

        // check if 0th row and 0th column have any '0' in it.
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) {
                col = true;
            }
        }

        for (int j = 0; j < c; j++) {
            if (matrix[0][j] == 0) {
                row = true;
            }
        }

        // now set the 0th row and 0th column's value to '0' whereever you find a '0' in
        // the matrix excluding 0th row and 0th column.
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // now the rows and columns whose value is set 0 in the above step, make entire
        // row and column 0.
        for (int i = 1; i < r; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < c; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < c; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < r; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // now if originally any row had any element 0 in the original matrix, make that
        // row 0.
        if (row) {
            for (int j = 0; j < c; j++) {
                matrix[0][j] = 0;
            }
        }

        // similarly, if originally any column had any element 0 in the original matrix,
        // make that column 0.
        if (col) {
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}


// Method 2:

class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (Integer r : rows) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[r][j] = 0;
            }
        }

        for (Integer c : cols) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][c] = 0;
            }
        }
    }
}