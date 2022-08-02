class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Queue<String> q = new LinkedList<>();
        int turns = 0;
        q.offer("0000");
        visited.add("0000");
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                String currentPosition = q.poll();
                if (deads.contains(currentPosition)) {
                    size--;
                    continue;
                }

                if (currentPosition.equals(target)) {
                    return turns;
                }
                StringBuilder sb = new StringBuilder(currentPosition);
                // calculate all positions and add to queue
                for (int i=0; i<4; i++) {
                    char curr = sb.charAt(i);
                    String sbIncrement = sb.substring(0, i) +
                        (curr == '9' ? 0 : curr - '0' + 1) + sb.substring(i + 1);

                    String sbDecrement = sb.substring(0, i) +
                        (curr == '0' ? 9 : curr - '0' - 1) + sb.substring(i + 1);

                    if (!visited.contains(sbIncrement) && !deads.contains(sbIncrement)) {
                        q.offer(sbIncrement);
                        visited.add(sbIncrement);
                    }
                    
                    if (!visited.contains(sbDecrement) && !deads.contains(sbDecrement)) {
                        q.offer(sbDecrement);
                        visited.add(sbDecrement);
                    }
                }
                size--;
            }
            
            turns++;
        }
        
        return -1;
    }
}
