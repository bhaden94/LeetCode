class Solution {
    private ArrayList<Integer> fillSquaresList(int n) {
        ArrayList<Integer> s = new ArrayList<>();
        int curSquare = 1, count = 1;
        while (curSquare <= n) {
            s.add(curSquare);
            count++;
            curSquare = count * count;
        }
        
        return s;
    }
    
    public int numSquares(int n) {
        ArrayList<Integer> squares = fillSquaresList(n);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        
        q.offer(n);
        
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            while (size-- > 0) {
                int num = q.poll();
                
                for (int square : squares) {
                    int remain = num - square;
                    
                    if (remain == 0) {
                        return level;   
                    } else if (remain > 0 && !visited.contains(remain)) {
                        visited.add(remain);
                        q.offer(remain);
                    } else if (remain < 0) {
                        break;
                    }
                }
            }
        }
        
        return level;
    }

} 
