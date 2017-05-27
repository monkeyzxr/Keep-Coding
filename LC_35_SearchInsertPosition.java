/**
 * Created by monkeyzxr on 2017/5/26.
 *

 Given a sorted array and a target value, return the index if the target is found.
 If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0

 */

//我写： 不正确
    /*
public class LC_35_SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (target < nums[0])
            return 0;
        else if (target > nums[nums.length-1])
            return nums.length;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target)
                return i;
            if (nums[i] < target && nums[i+1] > target)
                return i;
        }

    }

    public static void main(String[] args) {
        int[]test = {1,3,5,6};
        System.out.println(searchInsert(test, 5));
        System.out.println(searchInsert(test, 2));
        System.out.println(searchInsert(test, 7));
        System.out.println(searchInsert(test, 0));

    }
}
*/

    //http://bangbingsyb.blogspot.com/2014/11/leetcode-search-insert-position.html
    // 二分查找法：思路就是每次取中间，如果等于目标即返回，否则根据大小关系切去一半。因此算法复杂度是O(logn)，空间复杂度O(1)
    //当循环结束时，如果没有找到目标元素，那么l一定停在恰好比目标大的index上，r一定停在恰好比目标小的index上.。所以return right的位置，
    // 此时上面是left的index  （就是： right index， target index， left index）

public class LC_35_SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
       if (nums == null || nums.length == 0)
           return 0;

       int left = 0;
       int right = nums.length - 1;
       int mid = 0;
       while(left <= right){
           mid = left + (right - left)/2;
           if(nums[mid] == target)
               return mid;
           else if (nums[mid] < target)  //左半边 切掉，没用了
               left = mid + 1;
           else
               right = mid - 1;
       }

       // 如果二分查，再array中没有找到：
        return left;
    }

    public static void main(String[] args) {
        int[]test = {1,3,5,6};
        System.out.println(searchInsert(test, 5));
        System.out.println(searchInsert(test, 2));
        System.out.println(searchInsert(test, 7));
        System.out.println(searchInsert(test, 0));

    }
}