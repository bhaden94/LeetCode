class Solution {
    public int mySqrt(int x) {
        // 1*1 = 1
        // 2*2 = 4
        // 3*3 = 9
        
        int left = 1, right = Integer.MAX_VALUE;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
        
        return 0;
    }
}