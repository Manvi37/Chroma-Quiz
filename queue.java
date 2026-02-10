class Queue {
    private int[] arr;
    private int front, rear, capacity;

    Queue(int size) {
        capacity = size;
        arr = new int[capacity];
        front = 0;
        rear = -1;
    }

    public void enqueue(int value) {
        if (rear == capacity - 1) return;
        arr[++rear] = value;
    }

    public int dequeue() {
        if (front > rear) return -1;
        return arr[front++];
    }

    public boolean isEmpty() {
        return front > rear;
    }
}
