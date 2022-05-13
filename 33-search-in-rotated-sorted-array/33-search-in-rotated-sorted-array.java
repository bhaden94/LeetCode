class Solution {
    public int search(int[] nums, int target) {       
        // find index of pivot point
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // determine which side our element is in
        int start = 0;
        int end = left;
        if (target >= nums[left] && target <= nums[nums.length - 1]) {
            start = left;
            end = nums.length - 1;
        }
        
        // run binary search on chosen side
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) return mid;
            
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
}
