class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        findAll(nums, target, 0, current, answer);
        return answer;
    }
    
    public static void findAll(int[] nums, int left, int start, List<Integer> current, List<List<Integer>> answer) {
        if (left == 0) {
            answer.add(new ArrayList<>(current));
            return;
        }
        if (left < 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            findAll(nums, left - nums[i], i, current, answer);
            current.remove(current.size() - 1);
        }
    }
}