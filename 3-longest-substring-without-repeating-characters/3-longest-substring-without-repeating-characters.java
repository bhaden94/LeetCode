class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set seen = new HashSet();
        int i = 0, j = 0, runningMax = 0, max = 0;
        int length = s.length();
        
        while(j < length) {
            char curr = s.charAt(j);
            if (seen.contains(curr)) {
                seen.clear();
                runningMax = 0;
                i++;
                j=i;
            } else {
                seen.add(curr);
                runningMax++;
                max = Math.max(runningMax, max);
                j++;
            }
        }
        
        return max;
    }
}