/**
 * LeetCode 62 Unique Paths (Medium)
 * as robot can only move down or right, first col and row is able to be accessed from above
 * and right respectively(single access method)
 * DP soln, TC: O(N^2), sum up number of ways to access each cell O(M*N)
 */
// 3rd impl

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                // first elements of row and col have only 1 way to access
                if(i==0||j==0) {
                    path[i][j] = 1;
                }
                // sum prev (above and left positions)
                else {
                    path[i][j] = path[i-1][j] + path[i][j-1];
                }
            }
        }
        return path[m-1][n-1];
    }
}
