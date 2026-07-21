import java.util.*;

public class AtMostNDistinct {

    public static int longestSubarrayWithAtMostNDistinct(int[] nums, int n) {

        Map<Integer, Integer> freq = new HashMap<>();

        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < nums.length; end++) {

            freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);

            while (freq.size() > n) {

                freq.put(nums[start], freq.get(nums[start]) - 1);

                if (freq.get(nums[start]) == 0) {
                    freq.remove(nums[start]);
                }

                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 1, 2, 3};

        System.out.println(longestSubarrayWithAtMostNDistinct(arr, 2));
    }
}