class CharStack {
    private char[] arr;
    private int top;

    CharStack(int size) {
        arr = new char[size];
        top = -1;
    }

    void push(char c) {
        arr[++top] = c;
    }

    char pop() {
        return arr[top--];
    }

    boolean isEmpty() {
        return top == -1;
    }
}

public class StackPractice {

    public static void main(String[] args) {

        String input = "HELLO";
        CharStack stack = new CharStack(input.length());

// Step 1: push characters
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

// Step 2: pop and build reversed string
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

// Step 3: print result
        System.out.println(reversed);

    }
}
