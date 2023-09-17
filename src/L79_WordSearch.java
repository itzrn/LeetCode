package src;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 */

public class L79_WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){ // search the first letter of the word, and then start dfs to search the word
            for(int j = 0; j< board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(recursion(board, i, j, 0, word)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean recursion(char[][] arr, int x, int y, int index, String word){
        if(x < 0 || y < 0 || arr[x][y] == '#'){ // base case, '#' used to identify the visited grid
            return false;
        }

        if(index == word.length()-1){ // when we reach to the last of the word, we got the word
            return true;
        }

        char temp = arr[x][y];
        arr[x][y] = '#';

        // taking four directions
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;

        if(x < arr.length - 1 && arr[x+1][y] == word.charAt(index + 1)){ // to go in this recursion, x < aa.length - 1, to avoid out of bound condition
            a = recursion(arr, x+1, y, index + 1, word);
        }

        if(y < arr[x].length - 1 && arr[x][y+1] == word.charAt(index + 1)){// to go in this recursion, y < arr[x].length - 1, to avoid out of bound condition
            b = recursion(arr, x, y+1, index + 1, word);
        }

        if(x > 0 && arr[x-1][y] == word.charAt(index + 1)){ // to go in this recursion, x > 0, to avoid out of bound condition
            c = recursion(arr, x-1, y, index + 1, word);
        }

        if(y > 0 && arr[x][y-1] == word.charAt(index + 1)){ // to go in this recursion, y > 0, to avoid out of bound condition
            d = recursion(arr, x, y-1, index + 1, word);
        }

        arr[x][y] = temp; // while backTracking, returning its character to the grid, for any other possible path
        return a || b || c || d; // either of the four directions, if we get true, we will return true
    }
}
