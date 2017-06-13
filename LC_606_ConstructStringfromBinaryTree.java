/**
 * Created by monkeyzxr on 2017/6/12.
 *
 You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

 The null node needs to be represented by empty parenthesis pair "()".

 And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

 Example 1:
 Input: Binary tree: [1,2,3,4]
    1
  /   \
  2     3
 /
 4

 Output: "1(2(4))(3)"

 Explanation: Originallay it needs to be "1(2(4)())(3()())",
 but you need to omit all the unnecessary empty parenthesis pairs.
 And it will be "1(2(4))(3)".

 Example 2:
 Input: Binary tree: [1,2,3,null,4]
     1
   /   \
  2     3
    \
     4

 Output: "1(2()(4))(3)"

 Explanation: Almost the same as the first example,
 except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.

 *
 */

// Pre Order: 先node，再左，再右

//我写： 正确
    //https://gist.github.com/jianminchen/d59661bc5b1aee4b72beb792666b206c
public class LC_606_ConstructStringfromBinaryTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static String tree2str(TreeNode t) {
        if(t == null) return "";

        if (t.left == null && t.right ==  null)
            return String.valueOf(t.val);

        else if (t.left != null && t.right != null)
            return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";

        else if (t.right == null)
            return t.val + "(" + tree2str(t.left) + ")";

        else if (t.left == null)
            return t.val + "()" + "(" + tree2str(t.right) + ")";

        return null;
    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        rootNode.left = node1;
        rootNode.right = node2;
        node1.left = node3;
        node1.right = node4;
        String resultString = tree2str(rootNode);
        System.out.println(resultString);

    }
}


