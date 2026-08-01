class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        int ones = 1;
        int higher = n;
        
        while (higher > 0) {
            int digit = higher % 10;
            higher = higher / 10;
            int lower = n % ones;
            
            if (digit == 0) count += higher * ones;
            else if (digit == 1) count += higher * ones + lower + 1;
            else count += (higher + 1) * ones;
            
            ones *= 10;
        }
        
        return count;
    }
}