class Stack {
    private String[] arr;
    private int top;

    Stack(int size) {
        arr = new String[size];
        top = -1;
    }

    public void push(String value) {
        if (top == arr.length - 1) return;
        arr[++top] = value;
    }

    public String pop() {
        if (top == -1) return null;
        return arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    // for testing only
    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}
