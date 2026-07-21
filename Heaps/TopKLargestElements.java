import java.util.*;

public class TopKLargestElements{

    public static List<Integer> topKLargest(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums){

            if (minHeap.size() < k){
                minHeap.offer(num);
            }

            else if (num > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(num);
            }
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args){
        int[] arr = {4, 9, 1, 7, 3, 12, 10};
        System.out.println(topKLargest(arr, 3));
    }
}