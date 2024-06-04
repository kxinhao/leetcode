/**
 * LeetCode 994 Rotting Oranges (Medium)
 * BFS solution with time and fresh counters
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
                if(grid[i][j] == 2) queue.offer(i * n + j);
                if(grid[i][j] == 1) fresh++;
            }
        }
        int time = 0;
        while(!queue.isEmpty()) {
            if(fresh>0) {
                // size stored in var to prevent value fluctuation upon poll()
                int size = queue.size();
                for(int i = 0; i<size; i++) {
                    int curr = queue.poll();
                    int x = curr/n;
                    int y = curr%n;
                    for(int[] dir : dirs) {
                        int nextX = x + dir[0];
                        int nextY = y + dir[1];
                        if(hasFreshOrange(grid, nextX, nextY)) {
                            queue.offer(nextX * n + nextY);
                            fresh--;
                        }
                    }
                }
                time++;
            }
            if(fresh==0) break;
        }
        return fresh == 0 ? time : -1;
    }
    private boolean hasFreshOrange(int[][] grid, int i, int j) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]!=1) return false;
        grid[i][j] = 2;
        return true;
    }
}
