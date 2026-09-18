class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[][] hash = new int[26][2];
        for (int i = 0; i < 26; i++) {
            hash[i][0] = -1;
            hash[i][1] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (hash[ch][0] == -1) {
                hash[ch][0] = i;
            }
            hash[ch][1] = i;
        }
        List<int[]> intervals = new ArrayList<>();
        for (int ch = 0; ch < 26; ch++) {
            if (hash[ch][0] == -1) {
                continue;
            }
            int start = hash[ch][0];
            int end = hash[ch][1];
            boolean valid = true;
            for (int i = start; i <= end; i++) {
                int c = s.charAt(i) - 'a';
                if (hash[c][0] < start) {
                    valid = false;
                    break;
                }
                end = Math.max(end, hash[c][1]);
            }
            if (valid) {
                intervals.add(new int[]{start, end});
            }
        }
        intervals.sort((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[1] - a[0], b[1] - b[0]);
        });
        List<String> result = new ArrayList<>();
        int prevEnd = -1;
        for (int[] interval : intervals) {
            if (interval[0] > prevEnd) {
                result.add(s.substring(interval[0], interval[1] + 1));
                prevEnd = interval[1];
            }
        }
        return result;
    }
}