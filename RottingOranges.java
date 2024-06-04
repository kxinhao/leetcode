/**
 * LeetCode 994 Rotting Oranges (Medium)
 * multi source BFS solution with matrix coords flattening to 1d index
 * 1d_Ind = (i*grid[0].length) + j // i = curr row, j = curr col, grid[0].length = matrix width
 * expansion from 1d ind to matrix indices:
 * x = 1d_Ind / grid[0].length
 * y = 1d_Ind % grid[0].length
 * alternative is to store matrix coords in queue
 * Time Complexity: O(nm), Space Complexity: O(nm);
 */
class Solution {
    private final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int m = grid.length, n = grid[0].length, fresh = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                // if rotting orange found, add the squashed 1d coords to queue
                if(grid[i][j] == 2) queue.offer(i * n + j);
                // if fresh orange found, increment fresh count
                if(grid[i][j] == 1) fresh++;
            }
        }
        int time = 0;
        while(!queue.isEmpty()) {
            // size stored in var to prevent value fluctuation upon poll()
            int size = queue.size();
            // for each rotting orange, check directions for fresh and decrement fresh count
            for(int i = 0; i<size; i++) {
                int curr = queue.poll();
                // expand squashed coords
                int x = curr/n;
                int y = curr%n;
                for(int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    if(hasFreshOrange(grid, nextX, nextY)) {
                        queue.offer(nextX * n + nextY);
                        // decrease fresh count and break if no more left
                        if(fresh--==0) break;
                    }
                }
            }
            // end of rot spread for the minute, increment time count
            time++;
        }
        // if fresh != 0, means unreachable fresh oranges exist, return -1
        return fresh == 0 ? time : -1;
    }
    private boolean hasFreshOrange(int[][] grid, int i, int j) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]!=1) return false;
        grid[i][j] = 2;
        return true;
    }
}
