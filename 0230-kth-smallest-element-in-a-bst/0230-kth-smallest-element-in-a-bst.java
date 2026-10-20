class Solution {
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }
    int i=0;
    int ans=0;
    public void inorder(TreeNode node, int k){
        if(node==null){
            return;
        }
        inorder(node.left, k);
        i++;
        if(i==k){
            ans=node.val;
            return;
        }
        inorder(node.right, k);
    }
}
