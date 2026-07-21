public class FirstLastOccurrence {

    public static int firstOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right-left)/2;

            if (arr[mid] == target) {
                ans = mid;
                right = mid - 1;
            }

            else if (arr[mid] < target)
                left = mid + 1;

            else
                right = mid - 1;
        }

        return ans;
    }

    public static int lastOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right-left)/2;

            if (arr[mid] == target) {
                ans = mid;
                left = mid + 1;
            }

            else if (arr[mid] < target)
                left = mid + 1;

            else
                right = mid - 1;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {2,4,4,4,5,6,7};

        System.out.println(firstOccurrence(arr,4));
        System.out.println(lastOccurrence(arr,4));
    }
}