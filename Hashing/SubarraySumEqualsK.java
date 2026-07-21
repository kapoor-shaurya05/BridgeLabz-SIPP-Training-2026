import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySumEqualsK(int[] nums, int k) {

        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int runningSum = 0;
        int answer = 0;

        for (int num : nums) {

            runningSum += num;
            answer += prefixCount.getOrDefault(runningSum - k, 0);
            prefixCount.put(runningSum, prefixCount.getOrDefault(runningSum, 0) + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        System.out.println(subarraySumEqualsK(arr, 2));
    }
}