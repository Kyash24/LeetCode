class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int stepsRight = Math.abs(i - startIndex);
                int stepsLeft = n - stepsRight;
                int shortestPath = Math.min(stepsRight, stepsLeft);
                minSteps = Math.min(minSteps, shortestPath);
            }
        }
        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }
}