class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            int width = right - left;
            int heightLeft = height[left];
            int heightRight = height[right];
            int water = width * Math.min(heightLeft, heightRight);
            maxWater = Math.max(maxWater, water);
            if (heightLeft < heightRight) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}