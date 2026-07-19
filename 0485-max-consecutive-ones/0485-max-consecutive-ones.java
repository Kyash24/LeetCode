class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ctr=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]==1){
            ctr++;
            ans=Math.max(ctr,ans);      
            }
            else{
                ctr=0;
            }
        }
        return ans;
    }
}