import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/6/24.
 *
 Given an array with n objects colored red, white or blue,
 sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.
 *
 */

//就是说，把一串数 0， 1， 2 最终排序为 00000。。。111111。。。。22222。。。

    //http://bangbingsyb.blogspot.com/2014/11/leetcode-sort-colors.html
    /*
    假设已经完成到如下所示的状态：

0......0   1......1  x1 x2 .... xm   2.....2
              |           |               |
            left        cur          right

(1) A[cur] = 1：已经就位，cur++即可
(2) A[cur] = 0：交换A[cur]和A[left]。由于A[left]=1或left=cur，所以交换以后A[cur]已经就位，cur++，left++
(3) A[cur] = 2：交换A[cur]和A[right]，right--。由于xm的值未知，cur不能增加，继续判断xm。
cur > right扫描结束。
     */

    //http://www.jiuzhang.com/solutions/sort-colors/

    //好好想一想
public class LC_75_SortColors {

    public static void swap (int[]nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int left = 0;
        int right = nums.length-1;

        int cur = 0;
        while (cur <= right){
            if (nums[cur] == 0){
                swap(nums, cur, left);
                cur++;
                left++;
            }
            else if (nums[cur] == 1){
                cur++;
            }
            else if (nums[cur] == 2){
                swap(nums, cur, right);
                right--;
            }
        }

    }

    public static void main(String[] args) {
        int[] test1 = {1,2,2,1,1,1,1,1,0,0,0,0,1};
        sortColors(test1);
        System.out.println(Arrays.toString(test1));

        int[] test2 = {1,1,1,2,2,2,0,0,0};
        sortColors(test2);
        System.out.println(Arrays.toString(test2));



    }
}
