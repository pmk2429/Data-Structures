package array;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */
public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) return 0;

        if (nums.length == 1) {
            return (nums[0] == 1) ? 1 : 0;
        }

        int maxCount = 0, sum = 0;
        for (int num : nums) {
            if (num == 1) {
                sum++;
            }
            else {
                if (sum > maxCount) {
                    maxCount = sum;
                }
                sum = 0;
            }
        }
        return Math.max(sum, maxCount);
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
