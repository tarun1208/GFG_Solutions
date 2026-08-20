/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    
    int maxDifference = Integer.MIN_VALUE;
    
    int maxDiff(Node root) {
        helper(root);
        return maxDifference;
    }

    private int helper(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.left == null && node.right == null) {
            return node.data;
        }

        int leftMin = helper(node.left);
        int rightMin = helper(node.right);

        int minChild = Math.min(leftMin, rightMin);

        maxDifference = Math.max(maxDifference, node.data - minChild);

        return Math.min(node.data, minChild);
    }
}