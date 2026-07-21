public class PacketBuffer {

    private int[] data;
    private int front;
    private int count;

    public PacketBuffer(int capacity) {

        data = new int[capacity];
        front = 0;
        count = 0;
    }

    // Enqueue
    public boolean enqueue(int packetId) {

        if (count == data.length) {
            return false;      // Queue Full
        }

        int rear = (front + count) % data.length;

        data[rear] = packetId;

        count++;

        return true;
    }

    // Dequeue
    public int dequeue() {

        if (count == 0) {
            throw new RuntimeException("Queue Empty");
        }

        int value = data[front];

        front = (front + 1) % data.length;

        count--;

        return value;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == data.length;
    }

    public static void main(String[] args) {

        PacketBuffer queue = new PacketBuffer(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue());
        queue.enqueue(40);
        System.out.println(queue.dequeue());
    }
}