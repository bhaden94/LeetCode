class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m * n);
        int colStart = 0, rowStart = 0, colEnd = n, rowEnd = m;
        
        while (res.size() < (m * n)) {
            // row to the right
            for(int i=colStart; i<colEnd && res.size() < (m*n); i++) {
                res.add(matrix[rowStart][i]);
            }
            rowStart++;
            // column down
            for(int i=rowStart; i<rowEnd && res.size() < (m*n); i++) {
                res.add(matrix[i][colEnd - 1]);
            }
            colEnd--;
            // row to the left
            for(int i=colEnd - 1; i>=colStart && res.size() < (m*n); i--) {
                res.add(matrix[rowEnd - 1][i]);
            }
            rowEnd--;
            // column up
            for(int i=rowEnd - 1; i>=rowStart && res.size() < (m*n); i--) {
                res.add(matrix[i][colStart]);
            }
            colStart++;
        }
        
        return res;
        
    }
}