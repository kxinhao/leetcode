/**
 * LeetCode 542 01 Matrix (Medium)
 * using private int[] class/array to store coords 
 * bfs from each 0 value coord to populate matrix with distance values
 */
// 2nd impl
// eg [[0,0,0],[0,1,0],[1,1,1]]
class Solution {
    // store right/left/up/down directions in 2d array for traversal
    private final int[][] dirs = new int [][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        // replace all 1 values found with -1 to prep storage of distance values
        // and store all 0 occurances in queue
        for(int i = 0; i<matrix.length;i++) {
            for(int j = 0; j<matrix[0].length;j++) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] = -1;
                } else  {
                    queue.offer(new int[]{i,j});
                }
            }
        }
        // extract each stored 0 value in queue and check each direction as stored in dirs for 
        // -1 value (1 value originally) and populate with distance value.
        // put new coord in queue based on directional change for further checking
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for(int i = 0; i<size; i++) {
                // extraction of 0 value coords
                int[] curr = queue.poll();
                for(int[] dir :dirs) {
                    int ii = curr[0] + dir[0];  // x-coord shift
                    int jj = curr[1] + dir[1];  // y-coord shift
                    // check within boundaries
                    if(ii >= 0 && jj >= 0 && ii < matrix.length && jj < matrix[0].length) {
                        // finding 1 value coord and replace with distance value
                        if(matrix[ii][jj] == -1) {
                            matrix[ii][jj] = length;
                            // addition of directional shifted coords
                            queue.offer(new int[]{ii,jj});
                        }
                    }
                }
            }
        }
        return matrix;
    }
}
