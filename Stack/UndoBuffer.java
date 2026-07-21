public class UndoBuffer {

    private String[] data;
    private int top;

    public UndoBuffer(int maxDepth) {
        data = new String[maxDepth];
        top = -1;
    }

    // Push
    public boolean push(String edit) {

        if (top == data.length - 1) {
            return false;      // Stack Overflow
        }

        data[++top] = edit;
        return true;
    }

    // Pop
    public String pop() {

        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }

        return data[top--];
    }

    // Peek
    public String peek() {

        if (isEmpty()) {
            throw new RuntimeException("Stack Empty");
        }

        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {

        UndoBuffer stack = new UndoBuffer(5);

        stack.push("Edit1");
        stack.push("Edit2");
        stack.push("Edit3");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}