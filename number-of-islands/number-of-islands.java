class Solution {
    public int numIslands(char[][] grid) {
        // queue for BFS
        Queue<Integer[]> q = new LinkedList<>();
        // keep track of islands
        int islands = 0;
        
        // loop through entire grid
        //   check if x,y is 1
        //     if is then change to zero
        //     increment islands
        //     add x,y to queue
        //   while (queue is not empty)
        //     dequeue
        //     check surrounding nodes
        //       if 1
        //         change to 0
        //         add current x,y to queue
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    grid[row][col] = '0';
                    islands++;
                    q.add(new Integer[]{row, col});
                }
                
                while (!q.isEmpty()) {
                    Integer[] curr = q.poll();
                    int r = curr[0];
                    int c = curr[1];
                    // r+1,c; r,c+1; r-1,c; r,c-1
                    if (r + 1 < grid.length && grid[r+1][c] == '1') {
                        grid[r+1][c] = '0';
                        q.add(new Integer[]{r+1, c});
                    }
                    if (c + 1 < grid[r].length && grid[r][c+1] == '1') {
                        grid[r][c+1] = '0';
                        q.add(new Integer[]{r, c+1});
                    }
                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
                        grid[r-1][c] = '0';
                        q.add(new Integer[]{r-1, c});
                    }
                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
                        grid[r][c-1] = '0';
                        q.add(new Integer[]{r, c-1});
                    }
                }
            }
        }
        return islands;
    }
}