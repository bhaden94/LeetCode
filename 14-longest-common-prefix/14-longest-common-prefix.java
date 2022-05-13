class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        
        int col = 0;
        int smallestLength = strs[0].length();
        StringBuilder res = new StringBuilder();
        char currentLetter;
        
        // find smallest string
        for (int i=1; i<strs.length; i++) {
            smallestLength = Math.min(strs[i].length(), smallestLength);
        }
        
        while (col < smallestLength) {
            currentLetter = strs[0].charAt(col);
            for (int i=1; i<strs.length; i++) {
                if (strs[i].charAt(col) != currentLetter) {
                    return res.toString();
                }
            }
            res.append(currentLetter);
            col++;
        }
        
        return res.toString();
    }
}