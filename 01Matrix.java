/**
 * LeetCode 542 01 Matrix (Medium)
 * using private Point class/array to store coords 
 */

class Solution {

    private class Point {
        int x, y;
        Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int[][] dirs = new int [][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i<matrix.length;i++) {
            for(int j = 0; j<matrix[0].length;j++) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] = -1;
                } else  {
                    queue.offer(new Point(i,j));
                }
            }
        }
    
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for(int i = 0; i<size; i++) {
                Point curr = queue.poll();
                for(int[] dir :dirs) {
                    int ii = curr.x + dir[0];
                    int jj = curr.y + dir[1];
                    if(ii >= 0 && jj >= 0 && ii < matrix.length && jj < matrix[0].length) {
                        if(matrix[ii][jj] == -1) {
                            matrix[ii][jj] = length;
                            queue.offer(new Point(ii,jj));
                        }
                    }
                }
            }
        }
        return matrix;
    }
}
