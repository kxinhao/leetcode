/**
 * LeetCode 54 Spiral Matrix (Medium)
 * 2 choices, recursive or iterative. iterative more intuitive for interviews
 * TC: O(m*n) m = matrix.length, n = matrix[0].length
 * SC: O(1)
 */

// 2nd impl
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0, left = 0, bot = matrix.length-1, right = matrix[0].length-1;
        boolean buildingPath = true;
        while(buildingPath) {
            for(int i = left; i<=right; i++) ans.add(matrix[top][i]);
            top++;
            if(top>bot) return ans;

            for(int i = top; i<=bot; i++) ans.add(matrix[i][right]);
            right--;
            if(right<left) return ans;

            for(int i = right; i>=left; i--) ans.add(matrix[bot][i]);
            bot--;
            if(bot<top) return ans;

            for(int i = bot; i>=top; i--) ans.add(matrix[i][left]);
            left++;
            if(left>right) return ans;
        }
        return ans;
    }
}

// with helper method and recursion
// 2nd impl
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
