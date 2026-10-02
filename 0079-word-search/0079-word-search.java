class Solution {
    public boolean exist(char[][] board, String word) {
        // Depth-First Search (DFS):
        // Perform a DFS on the grid starting from each cell.
        
        // Iterate through each cell in the grid
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // Start DFS from each cell to search for the word
                if (dfs(board, word, i, j, 0))
                    return true; // If the word is found, return true
            }
        }
        // If the word is not found after searching all cells, return false
        return false;
    }
    
    // Depth-First Search (DFS) function to search for the word starting from position (i, j)
    public boolean dfs(char[][] board, String word, int i, int j, int idx) {
        // Check if (i, j) is out of bounds or if the character at (i, j) does not match the next character in the word
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx))
            return false;
        
        // If idx reaches the end of the word, it means the entire word is found
        if (idx == word.length() - 1)
            return true;
        
        // Temporarily store the current character at (i, j)
        char tmp = board[i][j];
        // Mark the current cell as visited by replacing its character with a special character '*'
        board[i][j] = '*';
        
        // Recursively search in adjacent cells to find the remaining characters of the word
        boolean res = dfs(board, word, i + 1, j, idx + 1) || dfs(board, word, i - 1, j, idx + 1) ||
                      dfs(board, word, i, j + 1, idx + 1) || dfs(board, word, i, j - 1, idx + 1);
        
        // Restore the character at (i, j) to its original value
        board[i][j] = tmp;
        
        return res;
    }
}