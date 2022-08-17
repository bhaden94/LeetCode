class Solution {
    private static boolean isBeginningParentheses(char c) {
          return c == '(' || c == '[' || c == '{'; 
    }
    
    private static boolean isCompliment(char stackChar, char compare) {
        if (stackChar == '(') {
            return compare == ')';
        }
        if (stackChar == '[') {
            return compare == ']';
        }
        if (stackChar == '{') {
            return compare == '}';
        }
        return false;
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (isBeginningParentheses(c)) {
                stack.add(c);
            } else if (!stack.empty()) {
                char popped = stack.pop();
                if (!isCompliment(popped, c)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return stack.empty();
    }
}