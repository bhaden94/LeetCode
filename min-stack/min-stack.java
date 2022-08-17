class MinStack {
    int min;
    ArrayList<Integer> stack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new ArrayList<Integer>();
    }
    
    public void push(int val) {
        min = Math.min(val, min);
        stack.add(val);
    }
    
    public void pop() {
        int topEl = this.top();
        stack.remove(stack.size() - 1);
        if (topEl == min) {
            min = stack.size() > 0 ? Collections.min(stack) : Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */