import java.util.Arrays;

public class Solution {

    public int findKthLargest(int[] nums, int k) {

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Find the kth largest element
        int result = nums[nums.length - k];

        return result;
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int answer = obj.findKthLargest(nums, k);

        System.out.println("Kth Largest Element: " + answer);
    }
}