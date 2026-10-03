class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();

        recurse(nums, k, n, 0, 0, ll, ans);
        return ans;
    }
    static void recurse(int[] nums, int k, int n, int idx, int sum, List<Integer> ll, List<List<Integer>> ans){
        if (ll.size() == k) {
            if (sum == n) ans.add(new ArrayList<>(ll));
            return;
        }
        for (int i=idx;i<nums.length;i++) {
            if (sum + nums[i] > n) break;
            ll.add(nums[i]);
            recurse(nums, k, n, i+1, sum+nums[i], ll, ans);
            ll.remove(ll.size()-1);
        }
    }
}