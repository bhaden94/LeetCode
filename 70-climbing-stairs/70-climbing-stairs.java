class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int back2 = 1, back1 = 2;
        for (int i=2; i<n; i++) {
            int sum = back2 + back1;
            back2 = back1;
            back1 = sum;
        }
        return back1;
    }
}
