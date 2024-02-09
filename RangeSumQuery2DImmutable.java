// 2nd impl, without null padding and full compre sumRegion
class NumMatrix {

    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int ylength = matrix.length;
        int xlength = matrix[0].length;
        sum = new int[ylength][xlength]; 
        sum[0][0] = matrix[0][0];

        // preprocess first row
        for(int x = 1; x < xlength; x++) {
            sum[0][x] = matrix[0][x] + sum[0][x-1];
        } 
        // preprocess first column
        for(int y = 1; y < ylength; y++) {
            sum[y][0] = matrix[y][0] + sum[y-1][0];
        }
        // preprocess rest
        for(int y = 1; y < ylength; y++) {
            for(int x = 1; x < xlength; x++) {
                sum[y][x] = matrix[y][x] + sum[y-1][x] + sum[y][x-1] - sum[y-1][x-1];
            }
        }

    }
    
    // must be 0(1)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = sum[row2][col2];

        if(row1 - 1 >=0 ) {
            total = total - sum[row1-1][col2];
        }
        if(col1 - 1 >= 0) {
            total = total - sum[row2][col1-1];
        }
        if(row1 - 1 >= 0 && col1-1 >= 0) {
            total = total + sum[row1 - 1][col1 - 1];
        }
        return total;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
