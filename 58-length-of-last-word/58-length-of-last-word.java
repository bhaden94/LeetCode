class Solution {
    public int lengthOfLastWord(String s){
        String trimmed = s.trim();
        return (trimmed.length() - 1 - trimmed.lastIndexOf(' '));
    }
}