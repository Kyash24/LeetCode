class Solution {
    public int missingInteger(int[] nums) {

        int sum = nums[0];

        // Find sequential prefix sum
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Find smallest missing integer
        while (true) {

            boolean found = false;

            for (int num : nums) {

                if (num == sum) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return sum;
            }

            sum++;
        }
    }
}