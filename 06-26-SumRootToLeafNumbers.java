/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    ArrayList<Integer> nums;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        nums = new ArrayList<>();
        helper(root, 0);
        int sum = 0;
        System.out.println(nums.toString());
        for (int num : nums) sum += num;

        return sum;
    }

    public void helper(TreeNode node, int num) {
        num = num * 10 + node.val;
        if (node.left == null && node.right == null) {
            nums.add(num);
            return;
        }
        if (node.left != null) helper(node.left, num);
        if (node.right != null) helper(node.right, num);

    }
}