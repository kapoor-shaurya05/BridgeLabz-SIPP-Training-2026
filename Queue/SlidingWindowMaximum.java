import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxThroughputWindow(int[] readings, int k) {

        int n = readings.length;

        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove indices outside current window
            while (!deque.isEmpty() &&
                    deque.peekFirst() <= i - k) {

                deque.pollFirst();
            }

            // Remove smaller elements
            while (!deque.isEmpty() &&
                    readings[deque.peekLast()] <= readings[i]) {

                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {

                result[i - k + 1] = readings[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxThroughputWindow(arr, 3)));
    }
}