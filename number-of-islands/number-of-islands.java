class Solution {
    // BFS
//     public int numIslands(char[][] grid) {
//         // [row,col]
//         Queue<Integer[]> q = new LinkedList<>();
//         int islands = 0;
        
//         for (int row = 0; row<grid.length; row++) {
//             for (int col = 0; col<grid[row].length; col++) {
//                 if (grid[row][col] == '0') continue;
                
//                 // if 1, find all surrounding ones
//                 q.offer(new Integer[]{row,col});
//                 grid[row][col] = '0';
//                 islands++;
//                 while (!q.isEmpty()) {
//                     Integer[] position = q.poll();
//                     int x = position[0];
//                     int y = position[1];
//                     // check surrounding
//                     if (x+1 < grid.length && grid[x+1][y] == '1') {
//                         grid[x+1][y] = '0';
//                         q.offer(new Integer[]{x+1,y});
//                     }
//                     if (x-1 >= 0 && grid[x-1][y] == '1') {
//                         grid[x-1][y] = '0';
//                         q.offer(new Integer[]{x-1,y});
//                     }
//                     if (y+1 < grid[x].length && grid[x][y+1] == '1') {
//                         grid[x][y+1] = '0';
//                         q.offer(new Integer[]{x,y+1});
//                     }
//                     if (y-1 >= 0 && grid[x][y-1] == '1') {
//                         grid[x][y-1] = '0';
//                         q.offer(new Integer[]{x,y-1});
//                     }
//                 }
//             }
//         }
        
//         return islands;
//     }
    
    // DFS
    public int numIslands(char[][] grid) {
        Stack<Integer[]> s = new Stack<>();
        int islands = 0;
        
        for (int row = 0; row<grid.length; row++) {
            for (int col = 0; col<grid[row].length; col++) {
                if (grid[row][col] == '0') continue;
                
                // if 1, find all surrounding ones
                s.add(new Integer[]{row,col});
                grid[row][col] = '0';
                islands++;
                while (!s.empty()) {
                    Integer[] position = s.pop();
                    int x = position[0];
                    int y = position[1];
                    // check surrounding
                    if (x+1 < grid.length && grid[x+1][y] == '1') {
                        grid[x+1][y] = '0';
                        s.add(new Integer[]{x+1,y});
                    }
                    if (x-1 >= 0 && grid[x-1][y] == '1') {
                        grid[x-1][y] = '0';
                        s.add(new Integer[]{x-1,y});
                    }
                    if (y+1 < grid[x].length && grid[x][y+1] == '1') {
                        grid[x][y+1] = '0';
                        s.add(new Integer[]{x,y+1});
                    }
                    if (y-1 >= 0 && grid[x][y-1] == '1') {
                        grid[x][y-1] = '0';
                        s.add(new Integer[]{x,y-1});
                    }
                }
            }
        }
        
        return islands;
    }
}