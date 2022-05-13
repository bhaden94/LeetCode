class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1, count = nums.length;
        
        while (left <= right) {
            // increment left until we see val
            //      decrement right until we do not see val
            //          swap
            //          move both inwards
            if (nums[left] == val) {
                if (nums[right] != val) {
                    nums[left] = nums[right];
                    nums[right] = val;
                    left++;
                }
                right--;
                count--;
            } else {
                left++;
            }
        }
        
        return count;
    }
}