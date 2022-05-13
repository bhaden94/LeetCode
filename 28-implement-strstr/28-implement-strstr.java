class Solution {
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);
        
        if (needle == null || needle.isEmpty()) return 0;
        
        // loop through haystack
        // check if next m char's match needle
        // if current position + m is greater than haystack length, return -1
        for (int i=0; i<haystack.length(); i++) {
            if (i + needle.length() - 1 >= haystack.length()) return -1;
            if (haystack.substring(i, i+needle.length()).equals(needle))
                return i;
        }
        
        return -1;
    }
}