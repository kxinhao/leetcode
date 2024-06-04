/**
 * LeetCode 200 Number of Islands (Medium)
 * DFS soln derived from flood fill approach
 */
// 1st impl
// DFS 3ms(85%) 49.1MB(74%)
class Solution {
    public int numIslands(char[][] grid) {
        // immediate return for empty grid
        if(grid.length==0||grid==null) return 0;
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

// BFS 6ms(19%) 51.98MB(13%)
class Solution {
    private final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        if(grid.length==0 || grid==null) return 0
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1' && !visited[i][j]) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                    bfsTrav(grid,queue,visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfsTrav(char[][] grid, Queue<int[]> queue, int[][] visited) {
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(x<0 || y<0 || x>=grid.length || y>= grid[0].length || visited[x][y] || grid[x][y]=='0')
                    continue;
                visited[x][y] = true;
                queue.offer(new int[]{x,y});
            }
        }
    }
}
