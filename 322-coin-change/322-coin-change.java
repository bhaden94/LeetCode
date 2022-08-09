class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        Queue<Integer> checks = new LinkedList<>();
        boolean[] seen = new boolean[amount];
        int amountOfCoins = 1;
        
        seen[amount-1] = true;
        checks.offer(amount);
        
        while (!checks.isEmpty()) {
            int size = checks.size();
            
            while (size > 0) {
                int currentAmount = checks.poll();
                
                for (int coin : coins) {
                    int remainder = currentAmount - coin;
                    
                    if (remainder == 0) {
                        return amountOfCoins;
                    } else if (remainder > 0 && !seen[remainder-1]) {
                        checks.offer(remainder);
                        seen[remainder-1] = true;
                    }
                }
                
                size--;
            }
            
            amountOfCoins++;
        }
        
        return -1;
    }
}