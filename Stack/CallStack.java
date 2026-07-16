public class CallStack {

    private static class Node {

        String functionName;
        Node next;

        Node(String functionName) {
            this.functionName = functionName;
        }
    }

    private Node top;

    // Push
    public void push(String functionName) {

        Node newNode = new Node(functionName);

        newNode.next = top;

        top = newNode;
    }

    // Pop
    public String pop() {

        if (isEmpty()) {
            throw new RuntimeException("Stack Empty");
        }

        String ans = top.functionName;

        top = top.next;

        return ans;
    }

    // Peek
    public String peek() {

        if (isEmpty()) {
            throw new RuntimeException("Stack Empty");
        }

        return top.functionName;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {

        CallStack stack = new CallStack();

        stack.push("main()");
        stack.push("login()");
        stack.push("validate()");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}