class Solution {
    public boolean checkDivisibility(int n) {
        int x = n, sum = 0, product = 1;

        while (x > 0) {
            int d = x % 10;
            sum += d;
            product *= d;
            x /= 10;
        }

        return n % (sum + product) == 0;
    }
}