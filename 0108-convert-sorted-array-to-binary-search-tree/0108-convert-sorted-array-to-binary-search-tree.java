/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length);
    }
    
    TreeNode build(int[] a, int i, int j) {
        if (i >= j) return null;
        int m = (i + j) / 2;
        TreeNode t = new TreeNode(a[m]);
        t.left = build(a, i, m);
        t.right = build(a, m + 1, j);
        return t;
    }
}