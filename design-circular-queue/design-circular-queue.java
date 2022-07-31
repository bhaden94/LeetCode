class MyCircularQueue {
    
    Integer[] arr;
    int frontPtr, rearPtr, size;
    
    public MyCircularQueue(int k) {
        arr = new Integer[k];
        size = 0;
        frontPtr = 0;
        rearPtr = -1;
    }
    
    public boolean enQueue(int value) {
        if (this.isFull()) return false;
        
        // at end of array we need to go to index 0
        if (++rearPtr == arr.length) {
            rearPtr = 0;
        }
        
        arr[rearPtr] = value;
        size++;
        
        return true;
    }
    
    public boolean deQueue() {
        if (this.isEmpty()) return false;
        
        if (++frontPtr == arr.length) {
            frontPtr = 0;
        }
        
        size--;

        return true;
    }
    
    public int Front() {
        return this.isEmpty() ? -1 : arr[frontPtr];
    }
    
    public int Rear() {
        return this.isEmpty() ? -1 : arr[rearPtr];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == arr.length;
    }
}


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */