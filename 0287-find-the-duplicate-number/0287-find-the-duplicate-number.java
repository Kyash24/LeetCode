class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[nums[i]]++;
            if (arr[nums[i]] > 1) {
                return nums[i];
            }
        }
        return n;
    }
}