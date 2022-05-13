class Solution {
    public int[] twoSum(int[] nums, int target) {     
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            int currentNum = nums[i];
            int compliment = target - currentNum;
            // check map if compliment exists
            if(map.containsKey(compliment)) {
                // compliment is there, return indexes
                return new int[] {i, map.get(compliment)};
            }
            // add number to index since it is not in map
            map.put(currentNum, i);
        }
        
        // return error if no match
        return new int[]{};
    }
}