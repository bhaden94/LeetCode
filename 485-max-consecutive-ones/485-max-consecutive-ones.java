class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int slow = 0, fast = 1, maxOnes = 0, currOnes = 0;
        
        // find first 1
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                slow = i;
                fast = i + 1;
                maxOnes = 1;
                currOnes = 1;
                break;
            }
        }
        
        while (fast < nums.length) {
            if (nums[fast] == 1) {
                maxOnes = Math.max(maxOnes, ++currOnes);
            } else {
                currOnes = 0;
                slow = fast;
            }
            fast++;
        }
        
        return maxOnes;
    }
}