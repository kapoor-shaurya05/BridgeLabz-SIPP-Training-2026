import java.util.*;

public class PrintQueue {

    private Deque<Integer> printQueue = new ArrayDeque<>();

    // Normal Job
    public void submitJob(int jobId) {
        printQueue.addLast(jobId);
    }

    // Urgent Job
    public void submitUrgentJob(int jobId) {
        printQueue.addFirst(jobId);
    }

    // Print Next Job
    public int printNextJob() {

        if (printQueue.isEmpty()) {
            throw new RuntimeException("Queue Empty");
        }

        return printQueue.removeFirst();
    }

    public static void main(String[] args) {

        PrintQueue queue = new PrintQueue();

        queue.submitJob(101);
        queue.submitJob(102);

        queue.submitUrgentJob(999);

        System.out.println(queue.printNextJob());
        System.out.println(queue.printNextJob());
    }
}