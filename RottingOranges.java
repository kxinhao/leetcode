/**
 * LeetCode 994 Rotting Oranges (Medium)
 * multi source BFS solution with matrix coords flattening to 1d index
 * 1d_Ind = (i*grid[0].length) + j // i = curr row, j = curr col, grid[0].length = matrix width
 * expansion from 1d ind to matrix indices:
 * x = 1d_Ind / grid[0].length
 * y = 1d_Ind % grid[0].length
 * alternative is to store matrix coords in queue, no diff in performance
 * TC: O(NM), SC: O(NM) worst case if all rotten will be added to queue
 */
// 4th impl

class Solution {
    private final int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int time = 0, fresh = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j]==2) queue.offer(new int[] {i,j});
                if(grid[i][j]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        while(!queue.isEmpty() && fresh>0) {
            time++;
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                int[] pos = queue.poll();
                for(int[] dir : dirs) {
                    int x = pos[0]+dir[0];
                    int y = pos[1]+dir[1];
                    if(x<0||y<0||x>grid.length-1||y>grid[0].length-1||grid[x][y]!=1) continue;
                    fresh--;
                    grid[x][y] = 2;
                    queue.offer(new int[] {x,y});
                }
            }
        }
        return fresh==0 ? time : -1;
    }
}
