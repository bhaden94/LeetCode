class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Queue<String> combinations = new LinkedList<>();
        int turns = 0;
        
        combinations.offer("0000");
        visited.add("0000");
        
        while (!combinations.isEmpty()) {
            int size = combinations.size();
            
            while (size > 0) {
                String currentCombination = combinations.poll();
                if (deads.contains(currentCombination)) {
                    size--;
                    continue;
                }
                
                if (currentCombination.equals(target)) {
                    return turns;
                }
                
                // try all combinations
                for (int i=0; i<4; i++) {
                    char currentWheel = currentCombination.charAt(i);
                    int wheelPlusOne = (currentWheel == '9') ? 0 : currentWheel - '0' + 1;
                    int wheelMinusOne = currentWheel == '0' ? 9 : currentWheel - '0' - 1;
                    
                    String combinationUp = currentCombination.substring(0,i) +
                        wheelPlusOne + currentCombination.substring(i+1);
                    
                    String combinationDown = currentCombination.substring(0,i) +
                        wheelMinusOne + currentCombination.substring(i+1);
                    
                    if (!visited.contains(combinationUp) && !deads.contains(combinationUp)) {
                        combinations.offer(combinationUp);
                        visited.add(combinationUp);
                    }
                    
                    if (!visited.contains(combinationDown) && !deads.contains(combinationDown)) {
                        combinations.offer(combinationDown);
                        visited.add(combinationDown);
                    }
                }
                
                size--;
            }
            turns++;    
        }
        
        return -1;
    }
}
