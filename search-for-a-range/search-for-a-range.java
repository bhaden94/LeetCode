class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        
        return res;
    }
    
    private static int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, firstIdx = -1;
        
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
        
        return firstIdx;
    }
    
    private static int findLast(int[] nums, int target) {
         int left = 0, right = nums.length - 1, lastIdx = -1;
        
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
        
        return lastIdx;
    }
}