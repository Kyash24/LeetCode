class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        
        for (int num : nums) {
            total -= num;
        }
        
        return total;
    }
}