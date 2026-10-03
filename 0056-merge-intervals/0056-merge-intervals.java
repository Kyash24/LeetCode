class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {

            // Overlapping intervals → merge them
            if (!ans.isEmpty() && interval[0] <= ans.get(ans.size() - 1)[1]) {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            }
            // Non-overlapping interval → add separately
            else {
                ans.add(interval);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}