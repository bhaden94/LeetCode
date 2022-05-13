class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return 1;
        
        int slow = 0, fast = 1, countDuplicates = 0;
        
        while(fast < nums.length) {
            if(nums[slow] != nums[fast]) {
                //swap nums[slow+1] with nums [fast]
                int temp = nums[slow+1];
                nums[++slow] = nums[fast];
                nums[fast++] = temp;
            } else {
                fast++;
                countDuplicates++;
            }
        }
        
        return (nums.length - countDuplicates);
    }
}