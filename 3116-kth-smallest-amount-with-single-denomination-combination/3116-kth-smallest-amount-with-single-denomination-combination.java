class Solution {

    public long findKthSmallest(int[] coins, int k) {

        Arrays.sort(coins);

        if (coins[0] == 1) return k;

        int n = coins.length, r = 0, c, j;

        for (int i = 0; i < n - r - 1; i++) {

            c = coins[i];
            j = i + 1;

            while (j < n - r) {
                if (coins[j] % c == 0) {

                    for (int x = j; x < n - r - 1; x++) {
                        coins[x] = coins[x + 1];
                    }

                    r++;

                } else {
                    j++;
                }
            }
        }

        if (n - r == 1) {
            return (long) coins[0] * k;
        }

        int a = n - r;

        long low = coins[0];
        long high = (long) coins[0] * k;
        long count;
        long result = 0;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            count = countNums(coins, mid, a);

            if (count >= k) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    int gcd(int a, int b) {

        int r;

        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    long lcm(long a, long b) {

        return a / gcd((int)a, (int)b) * b;
    }

    long countNums(int[] c, long m, int a) {

        long sum = 0;

        int totalMasks = 1 << a;

        for (int mask = 1; mask < totalMasks; mask++) {

            long common = 1;
            int bits = 0;

            for (int i = 0; i < a; i++) {

                if ((mask & (1 << i)) != 0) {

                    common = lcm(common, c[i]);
                    bits++;
                }
            }

            if ((bits & 1) == 1) {
                sum += m / common;
            } else {
                sum -= m / common;
            }
        }

        return sum;
    }
}