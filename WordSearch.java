/**
 * LeetCode 79 Word Search (Medium)
 * TC: O(4^N) where N is length of word and 4 is the directions
 * SC: O(N) due to recursion use of space = input length
 * soln mutates input board array, if interview req no mutation, use visitation matrix instead
 */
// 3rd impl

class Solution {
    public boolean exist(char[][] board, String word) {
        // find start point for word
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[0].length;j++) {
                if(traverse(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean traverse(char[][] board, String word, int row, int col, int ind) {
        // if recursion manages to reach end of word, path forming word exists
        if(ind==word.length()) return true;
        // return false if oob or board character is not equal to word char being checked
        if(row>board.length-1 || row<0 || col<0 || col>board[0].length-1 || board[row][col]!=word.charAt(ind)) {
            return false;
        }
        // replace board character with non-alphabet to prevent revisiting while forming this path,
        // alternatively use visit matrix at cost of space
        board[row][col] = '*';
        // check if next char in word can be found in left, up, right or down locations
        boolean res = traverse(board, word, row-1, col, ind+1) ||
                      traverse(board, word, row, col-1, ind+1) ||
                      traverse(board, word, row+1, col, ind+1) ||
                      traverse(board, word, row, col+1, ind+1);
        // replace original char after exploring possible paths for this coord
        // so that new path can use this char
        board[row][col] = word.charAt(ind);
        return res;
    }
}
