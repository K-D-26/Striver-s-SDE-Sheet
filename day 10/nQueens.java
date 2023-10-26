class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        List<List<String>> ans = new ArrayList<>();
        int[] left = new int[n];
        int[] upperDiagonal = new int[2*n - 1];
        int[] lowerDiagonal = new int[2*n - 1];
        recur(0, ans, board, left, upperDiagonal, lowerDiagonal);
        return ans;
    }
    
    private static void recur(int col, List<List<String>> ans, char[][] board, int[] left, int[] ud, int[] ld) {
        if (col == board.length) {
            ans.add(construct(board));
            return;
        }
        
        for (int row = 0; row < board.length; row++) {
            // check if it is safe to add queen at this position
            if (left[row] == 0 && ld[row + col] == 0 && ud[board.length-1 + (col-row)] == 0) {
                board[row][col] = 'Q';
                left[row] = 1;
                ld[row + col] = 1;
                ud[board.length-1 + (col-row)] = 1;
                
                recur(col + 1, ans, board, left, ud, ld);
                
                board[row][col] = '.';
                left[row] = 0;
                ld[row + col] = 0;
                ud[board.length-1 + (col-row)] = 0;
            }
        }
    }
    
    private static List<String> construct(char[][] board) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s =  new String(board[i]);
            ans.add(s);
        }
        
        return ans;
    }
}