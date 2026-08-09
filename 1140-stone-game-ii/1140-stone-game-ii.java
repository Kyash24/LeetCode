class Solution {
    public int stoneGameII(int[] piles) {

        int n = piles.length;

        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        int[][] dp = new int[n][n + 1];

        for (int i = n - 1; i >= 0; i--) {

            for (int M = 1; M <= n; M++) {

                if (2 * M >= n - i) {
                    dp[i][M] = suffix[i];
                    continue;
                }

                int best = 0;

                for (int x = 1;
                     x <= 2 * M && i + x <= n;
                     x++) {

                    int nextM = Math.max(M, x);

                    int current =
                        suffix[i] - dp[i + x][nextM];

                    best = Math.max(best, current);
                }

                dp[i][M] = best;
            }
        }

        return dp[0][1];
    }
}