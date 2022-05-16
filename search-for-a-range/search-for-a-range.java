class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int firstIdx = -1, lastIdx = -1;
        
        // first first occurance
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                firstIdx = mid;
                right = mid - 1;
            }
        }
        
        left = 0;
        right = nums.length - 1;
        // find last occurance
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                lastIdx = mid;
                left = mid + 1;
            }
        }
        
        return new int[]{firstIdx, lastIdx};
    }
}