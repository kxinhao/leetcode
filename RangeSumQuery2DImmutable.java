// 3rd impl, using padding method
class NumMatrix {

    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        // skip edge case check by padding first row/col with empty ints
        sum = new int[rowLength+1][colLength+1]; 
        for(int i = 1; i <= rowLength; i++) {
          for(int j = 1; j <= colLength; j++) {
            sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
          }
        }
/*
        // preprocess first row
        for(int x = 1; x < colLength; x++) {
            sum[0][x] = matrix[0][x] + sum[0][x-1];
        } 
        // preprocess first column
        for(int y = 1; y < rowLength; y++) {
            sum[y][0] = matrix[y][0] + sum[y-1][0];
        }
        // preprocess rest
        for(int y = 1; y < rowLength; y++) {
            for(int x = 1; x < colLength; x++) {
                sum[y][x] = matrix[y][x] + sum[y-1][x] + sum[y][x-1] - sum[y-1][x-1];
            }
        }
*/
    }
    
    // must be 0(1)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // taking total area - col - row + overlap
        return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 **/
