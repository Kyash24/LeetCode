class Solution {
    public int minimumCost(int[] nums) {
        int small = Integer.MAX_VALUE;
        int secondsmall = Integer.MAX_VALUE;
        for(int i=1; i<nums.length;i++){
            if(nums[i]<small){
                secondsmall=small;
                small=nums[i];
            }
            else if(nums[i]<secondsmall){
                secondsmall=nums[i];
            }
        }
        return nums[0]+small+secondsmall;
    }
}