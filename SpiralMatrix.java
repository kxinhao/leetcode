/**
 * LeetCode 54 Spiral Matrix (Medium)
 * TC: O(m*n) m = matrix.length, n = matrix[0].length
 */

class Solution {
   
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        if(matrix.length==0||matrix[0].length==0) return ans;

        int minRow = 0, maxRow = matrix.length-1;
        int minCol = 0, maxCol = matrix[0].length-1;
        spiral(matrix, ans, minRow, maxRow, minCol, maxCol);
        return ans;
    }

    private void spiral(int[][] matrix, List<Integer> ans, int minRow, int maxRow, int minCol, int maxCol) {
        for(int i = minCol; i<=maxCol; i++) ans.add(matrix[minRow][i]);
        minRow++;
        if(minRow>maxRow||minCol>maxCol) return;

        for(int i = minRow; i<=maxRow; i++) ans.add(matrix[i][maxCol]);
        maxCol--;
        if(minRow>maxRow||minCol>maxCol) return;

        for(int i = maxCol; i>=minCol; i--) ans.add(matrix[maxRow][i]);
        maxRow--;
        if(minRow>maxRow||minCol>maxCol) return;

        for(int i = maxRow; i>=minRow; i--) ans.add(matrix[i][minCol]);
        minCol++;
        if(minRow>maxRow||minCol>maxCol) return;
        spiral(matrix, ans, minRow, maxRow, minCol, maxCol);
    }
}
