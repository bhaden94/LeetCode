class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = left + (right - left) / 2;
        
        while (left < right) {
            int curr = nums[mid];
            if (curr == target) return mid;
            
            if (curr < target)
                left = mid + 1;
            else
                right = mid;
            
            mid = left + (right - left) / 2;
        }
        
        int length = nums.length - 1;
        if (mid == length && target > nums[length])
            return mid + 1;
        
        return mid;
    }
}