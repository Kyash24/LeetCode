class Solution {
    public int smallestNumber(int n, int t) {

        while (true) {

            int product = digitProduct(n);

            if (product % t == 0) {
                return n;
            }

            n++;
        }
    }

    private int digitProduct(int num) {

        int product = 1;

        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }

        return product;
    }
}