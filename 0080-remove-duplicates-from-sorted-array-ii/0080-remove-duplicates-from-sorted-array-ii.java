class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        
        int newLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int countForThisNumber = 0;
            
            while (i < nums.length && nums[i] == currentNumber) {
                countForThisNumber++;
                i++;
            }
            
            int numbersToKeep = Math.min(countForThisNumber, 2);
            
            for (int j = 0; j < numbersToKeep; j++) {
                nums[newLength] = currentNumber;
                newLength++;
            }
            
            i--;
        }
        
        return newLength;
    }
}