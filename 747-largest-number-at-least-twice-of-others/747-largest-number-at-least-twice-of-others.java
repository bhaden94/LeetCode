class Solution {
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        
        // find max element index
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        
        // test that it is twice as big as every other element
        //  retunr -1 if ever false
        for(int i=0; i<nums.length; i++) {
            if(i == maxIndex) continue;
            if(nums[maxIndex] < (nums[i] * 2)) return -1;
        }
        
        return maxIndex;
    }
}