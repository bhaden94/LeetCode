class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int currMax = 0;
        
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            currMax = Math.max(currMax, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return currMax;
    }
}