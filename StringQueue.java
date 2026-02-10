class StringQueue {
    private String[] arr;
    private int front, rear, capacity;

    StringQueue(int size) {
        capacity = size;
        arr = new String[capacity];
        front = 0;
        rear = -1;
    }

    public void enqueue(String value) {
        if (rear == capacity - 1) {
            return; // Queue full (FA usually ignores overflow)
        }
        arr[++rear] = value;
    }

    public String dequeue() {
        if (front > rear) {
            return null; // Queue empty
        }
        return arr[front++];
    }

    public boolean isEmpty() {
        return front > rear;
    }
}
