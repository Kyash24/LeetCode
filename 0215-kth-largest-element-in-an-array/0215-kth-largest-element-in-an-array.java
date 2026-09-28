class Solution {
    public int findKthLargest(int[] nums, int k) {

        return Arrays
        .stream(nums)
        .boxed()
        .collect(Collectors.toList())
        .stream()
        .sorted(Comparator.reverseOrder())
        .skip(k-1)
        .findFirst()
        .orElse(-1);
        
    }
}