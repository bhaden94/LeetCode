class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1])
            return nums.length;
        if (target < nums[0])
            return 0;
        
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
        
        return mid;
    }
}