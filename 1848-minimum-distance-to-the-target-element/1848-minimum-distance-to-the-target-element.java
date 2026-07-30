class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDistance = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int distance = Math.abs(i - start);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }
}