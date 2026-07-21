public class FixedWindow {

    public static int maxSubarrayOfSizeK(int[] arr, int k) {

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        int start = 0;

        for (int end = 0; end < arr.length; end++) {

            windowSum += arr[end];

            if (end >= k - 1) {

                maxSum = Math.max(maxSum, windowSum);

                windowSum -= arr[start];

                start++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 1, 3, 2};

        System.out.println(maxSubarrayOfSizeK(arr, 3));
    }
}