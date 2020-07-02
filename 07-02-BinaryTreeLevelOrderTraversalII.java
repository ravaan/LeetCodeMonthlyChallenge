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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();
        if (root == null) return answer;
        answer.add(new ArrayList<Integer>());
        int prevLevel = 0;
        q.add(new Node(root, 0));
        while (!q.isEmpty()) {
            Node currNode = q.poll();
            int currLevel = currNode.level;
            TreeNode currTreeNode = currNode.node;

            if (currLevel > prevLevel) {
                ArrayList<Integer> nextLevel = new ArrayList<>();
                answer.add(nextLevel);
                prevLevel = currLevel;
            }

            answer.get(currLevel).add(currTreeNode.val);

            if (currTreeNode.left != null) {
                q.add(new Node(currTreeNode.left, currLevel + 1));
            }
            if (currTreeNode.right != null) {
                q.add(new Node(currTreeNode.right, currLevel + 1));
            }

        }
        Collections.reverse(answer);
        return answer;
    }
}

class Node {
    TreeNode node;
    int level;

    public Node(TreeNode node, int level) {
        this.level = level;
        this.node = node;
    }
}
