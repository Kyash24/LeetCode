class Solution {
    public int findNumbers(int[] nums) {
        int ctr=0;
        for(int i=0;i<nums.length;i++){
            if(even(nums[i])){
                ctr ++;
            }
        }
        return ctr;
    }
    static boolean even(int num){
        int noofdigits=digits(num);
        if(noofdigits%2==0){
            return true;
        }
        return false;
    }
    static int digits(int numb){
        int ctr=0;
        while(numb>0){
            ctr++;
            numb=numb/10;
        }
        return ctr;
    }
    }

