// 9th impl
class NumMatrix {

    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        // skip edge cases of leftmost and topmost elements in sum array population formula
        // by padding first row/col with empty ints
        sum = new int[rowCount+1][colCount+1]; 
        for(int i = 1; i <= rowCount; i++) {
          for(int j = 1; j <= colCount; j++) {
            // sum of row above, col to left, matrix element value and subtract added row/col overlap
            sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
          }
        }

    }
    
    // must be 0(1)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // because of null padding in sum array, we +1 to 2d array coords formula to find sum
        // max area bound row2, col2 subtract min row1 to col2+1 and subtract min row2+1 to col1,
        // then add back the excess subtraction:
        // taking total area bound by (row2, col2) - col - row + overlap of col and row
        // sum[row2][col1] - sum[row1-1][col2] - sum[row2][col1-1] + sum[row1-1][col1-1];
        return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 **/
