class Solution {
    public void solve(char[][] board) {
        Queue<List<Integer>> boardSpots = new LinkedList<>();
        boolean[][] shouldNotFlip = new boolean[board.length][board[0].length];
        
        // find spots we don't want to flip
        for (int row=0; row<board.length; row++) {
            for (int col=0; col<board[row].length; col++) {
                if ((board[row][col] == 'O') &&
                    ((row == 0 || col == 0) ||
                    (row == board.length - 1 || col == board[row].length - 1))) {
                    // BFS on all connected nodes
                    boardSpots.offer(List.of(row, col));
                    shouldNotFlip[row][col] = true;
                    
                    while (!boardSpots.isEmpty()) {
                        List<Integer> currentSpot = boardSpots.poll();
                        int x = currentSpot.get(0);
                        int y = currentSpot.get(1);
                        
                        // check surrounding nodes
                        if (x-1 >= 0 && board[x-1][y] == 'O' && !shouldNotFlip[x-1][y]) {
                            List<Integer> nextO = List.of(x-1, y);
                            shouldNotFlip[x-1][y] = true;
                            boardSpots.offer(nextO);
                        }
                        if (x+1 < board.length && board[x+1][y] == 'O' && !shouldNotFlip[x+1][y]) {
                            List<Integer> nextO = List.of(x+1, y);
                            shouldNotFlip[x+1][y] = true;
                            boardSpots.offer(nextO);
                        }
                        if (y-1 >= 0 && board[x][y-1] == 'O' && !shouldNotFlip[x][y-1]) {
                            List<Integer> nextO = List.of(x, y-1);
                            shouldNotFlip[x][y-1] = true;
                            boardSpots.offer(nextO);
                        }
                        if (y+1 < board[x].length && board[x][y+1] == 'O' && !shouldNotFlip[x][y+1]) {
                            List<Integer> nextO = List.of(x, y+1);
                            shouldNotFlip[x][y+1] = true;
                            boardSpots.offer(nextO);
                        }
                    }
                }
            }
        }
        
        // flip all other 'O's
        for (int row=0; row<board.length; row++) {
            for (int col=0; col<board[row].length; col++) {
                if (board[row][col] == 'O' && !shouldNotFlip[row][col]) {
                    board[row][col] = 'X';
                }
            }
        }
        
    }
}
