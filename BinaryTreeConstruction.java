
/*QUESTION[4]-You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
You always start to construct the **left** child node of the parent first if it exists.
**Input:** s = "4(2(3)(1))(6(5))"

**Output:** [4,2,6,3,1,5]
*/
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeConstruction {
    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        TreeNode root = constructBinaryTree(s);
        
        // Test the constructed binary tree
        System.out.println("Inorder traversal:");
        inorderTraversal(root);
    }
    
    public static TreeNode constructBinaryTree(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                int numStart = i;
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                }
                int num = Integer.parseInt(s.substring(numStart, i + 1));
                TreeNode node = new TreeNode(num);
                
                if (root == null) {
                    root = node;
                } else {
                    TreeNode parent = stack.peek();
                    if (parent.left == null) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }
                
                stack.push(node);
            } else if (ch == ')') {
                stack.pop();
            }
        }
        
        return root;
    }
    
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
}
