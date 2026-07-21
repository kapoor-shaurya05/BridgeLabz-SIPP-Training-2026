import java.util.*;

public class Triplets {

    public static List<List<Integer>> findTriplets(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1])
                        left++;

                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                }

                else if (sum < target) {
                    left++;
                }

                else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, -2, 0, -1, 1};
        System.out.println(findTriplets(arr, 0));
    }
}