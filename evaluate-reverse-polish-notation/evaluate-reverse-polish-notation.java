class Solution {
    private boolean isOperation(String str) {
        return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }
    
    private int performOperation(String operation, int leftNum, int rightNum) {
        int res = 0;
        
        switch(operation) {
            case "+":
                res = leftNum + rightNum;
                break;
            case "-":
                res = leftNum - rightNum;
                break;
            case "*":
                res = leftNum * rightNum;
                break;
            case "/":
                res = leftNum / rightNum;
                break;
            default:
                return res;
        }
        
        return res;
    }
    
    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> numbers = new Stack<>();
        
        for (String str : tokens) {
            if (isOperation(str)) {
                if (!numbers.empty() && numbers.size() > 1) {
                    int rightNum = numbers.pop();
                    int leftNum = numbers.pop();
                    int operationRes = performOperation(str, leftNum, rightNum);
                    numbers.add(operationRes);
                    res = operationRes;
                }
            } else {
                numbers.add(Integer.parseInt(str));
            }
        }
        
        if (numbers.size() == 1) {
            return numbers.pop();
        }
        
        return res;
    }
}
