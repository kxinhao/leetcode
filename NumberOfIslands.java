/**
 * LeetCode 200 Number of Islands (Medium)
 * DFS soln derived from flood fill approach
 */

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    skipIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    private void skipIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0')
            return;
        // assign to 2 to prevent usage of water representation
        if(grid[i][j]=='1'){
            grid[i][j] = '2';
            skipIsland(grid, i, j - 1);
            skipIsland(grid, i, j + 1);
            skipIsland(grid, i - 1, j);
            skipIsland(grid, i + 1, j);
        }
    }
}
