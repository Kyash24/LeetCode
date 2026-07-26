class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] merged = new int[nums1.length + nums2.length];
        
        for(int i = 0; i < nums1.length; i++){
            merged[i] = nums1[i];
        }
        for(int i = 0; i < nums2.length; i++){
            merged[nums1.length + i] = nums2[i];
        }
        
        Arrays.sort(merged);
        
        int n = merged.length;
        
        if(n % 2 != 0){
            return merged[n/2];
        }
        
        return (merged[n/2 - 1] + merged[n/2]) / 2.0;
    }
}