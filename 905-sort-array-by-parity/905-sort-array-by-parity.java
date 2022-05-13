class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        //ptr at 0 and nums.length - 1
        int left = 0, right = nums.length - 1;
        
        //loop until ptrs cross
        //  if one odd and one even, chekc if we need to swap them
        // if both even, increment left ptr
        // if both odd, increment right ptr
        
        // [0,1]
        //  | |
        // le = 0
        // re = 1
        
        while (left < right) {
            int leftEl = nums[left];
            int rightEl = nums[right];
            if (leftEl % 2 == 0 && rightEl % 2 == 0) {
                left++;
            } else if (leftEl % 2 != 0 && rightEl % 2 != 0) {
                right--;
            } else {
                if (leftEl % 2 != 0) {
                    nums[left] = rightEl;
                    nums[right] = leftEl;
                }
                left++;
                right--;
            }
        }
        
        return nums;
        
    }
}