/**
 * Created by monkeyzxr on 2017/6/14.
 *
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */


//我自己写，思路不对。
    /*
public class LC_108_ConvertSortedArraytoBinarySearchTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  // 0,1,2,3,4,5,6,7,8
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        TreeNode root = new TreeNode(nums[len/2]);
        int toLeft = len/2 - 1;
        int toRight = len/2 + 1;

        while(toLeft >=0 || toRight < len){
            TreeNode left = new TreeNode(nums[toLeft]);
            TreeNode right = new TreeNode(nums[toRight]);
            root.left = left;
            root.right = right;
            toLeft--;
            toRight++;
        }

    }

    public static void main(String[] args) {

    }
}
*/
    //我重新写：
//思路：
/*
1) Get the Middle of the linked list and make it root.
2) Recursively do same for left half and right half.
       a) Get the middle of left half and make it left child of the root
          created in step 1.
       b) Get the middle of right half and make it right child of the
          root created in step 1.
 */

//http://www.jiuzhang.com/solutions/convert-sorted-array-to-binary-search-tree/
//http://www.jiuzhang.com/solutions/convert-sorted-array-to-binary-search-tree/
//http://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
public class LC_108_ConvertSortedArraytoBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode buildTree(int[] nums, int start, int end){
        if (start > end)
            return null;

        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid-1);
        root.right = buildTree(nums, mid+1, end);

        return root;
    }

    // 0,1,2,3,4,5,6,7,8
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null)
            return null;

        return buildTree(nums, 0, nums.length-1);

    }

    public static void main(String[] args) {

    }
}