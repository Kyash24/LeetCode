class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for(int num : nums){
            int n = outer.size();
            for(int i = 0; i < n; i++){
                // Create a new subset from existing one
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal); // Add it to the list
            }
        }
        return outer;
    }
}