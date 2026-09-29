class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int mx = 0;

        for (int i = 0; i <= n; i++) {
            int alt = 0;
            for (int j = 0; j < i; j++) {
                alt += gain[j];
            }
            mx = Math.max(mx, alt);
        }

        return mx;
    }
}