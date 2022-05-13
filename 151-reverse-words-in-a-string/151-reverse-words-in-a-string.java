class Solution {
    public String reverseWords(String s) {
        // trim whitespace
        String trimmed = s.replaceAll("\\s+", " ").trim();
        // split string on spaces
        String[] split = trimmed.split(" ");
        // reverse array
        int left = 0, right = split.length - 1;
        while (left < right) {
            String temp = split[left];
            split[left++] = split[right];
            split[right--] = temp;
        }
        // join array back with single space deliminator
        return String.join(" ", split);
    }
}