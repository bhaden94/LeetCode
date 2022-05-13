class Solution {
    public int heightChecker(int[] heights) {
        int[] sortedCopy = Arrays.copyOf(heights, heights.length);
        int count = 0;
        Arrays.sort(sortedCopy);
        
        for(int i=0; i<heights.length; i++) {
            if(heights[i] != sortedCopy[i]) 
                count++;
        }
        
        return count;
    }
}