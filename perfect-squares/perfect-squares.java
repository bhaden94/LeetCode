class Solution {
    private ArrayList<Integer> generatePerfectSquares(int n) {
        ArrayList<Integer> squares = new ArrayList<>();
        int square = 1, count = 1;
        
        while (square <= n) {
            squares.add(square);
            count++;
            square = count * count;
        }
        
        return squares;
    }
    
    public int numSquares(int n) {
        ArrayList<Integer> squares = generatePerfectSquares(n);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> results = new LinkedList<>();
        int level = 1;
        results.offer(n);
        
        while (!results.isEmpty()) {
            int size = results.size();
            while (size > 0) {
                int currentResult = results.poll();
                
                for (int s : squares) {
                    int remainder = currentResult - s;
                    
                    if (remainder == 0) {
                        return level;
                    } else if (remainder > 0 && !visited.contains(remainder)) {
                        visited.add(remainder);
                        results.offer(remainder);
                    }
                }
                
                size--;
            }
            
            level++;
        }
        
        return level;
    }

} 
