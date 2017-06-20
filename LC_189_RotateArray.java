import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/6/19.
 *
 Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

 [show hint]

 Hint:
 Could you do it in-place with O(1) extra space?
 Related problem: Reverse Words in a String II
 *
 */


//网上方法：http://www.programcreek.com/2015/03/rotate-array-in-java/
    // we do this in O(1) space. This solution is like a bubble sort.

/*
    However, the time is O(n*k).

Here is an example (length=7, order=3):

i=0
0 1 2 3 4 5 6
0 1 2 3 4 6 5
...
6 0 1 2 3 4 5


i=1
6 0 1 2 3 5 4
...
5 6 0 1 2 3 4


i=2
5 6 0 1 2 4 3
...
4 5 6 0 1 2 3

*/

/*
public class LC_189_RotateArray {
    public static void rotate(int[] nums, int k) {
        if (nums == null || k < 0)
            return;

        for (int i = 0; i < k; i++){  // 循环k次
            for (int j = nums.length-1; j > 0; j--){  //将最右端的数一直往左移动，直到移动到最左端
                int tmp = nums[j];
                nums[j] =  nums[j-1];
                nums[j-1] = tmp;
            }
        }


    }

    public static void main(String[] args) {
        int[]test = {1,2,3,4,5,6,7};
        rotate(test,3);
        System.out.println(Arrays.toString(test));
    }
}
*/

//方法2：
/*
以n - k为界，分别对数组的左右两边执行一次逆置；然后对整个数组执行逆置。
reverse(nums, 0, n - k - 1)
reverse(nums, n - k, n - 1)
reverse(nums, 0, n - 1)
------------------------------------
Assuming we are given {1,2,3,4,5,6} and order 2. The basic idea is:

1. Divide the array two parts: 1,2,3,4 and 5, 6
2. Reverse first part: 4,3,2,1,  5,6
3. Reverse second part: 4,3,2,1,  6,5
4. Reverse the whole array: 5,6,1,2,3,4
 */

//http://www.programcreek.com/2015/03/rotate-array-in-java/
public class LC_189_RotateArray {
    public static void reserve(int[] arr, int left, int right){
        if (arr == null ||arr.length == 1)
            return;

        while(left < right){
            int tmp = arr[left];  //最左端和最右端的数 互换
            arr[left] = arr[right];
            arr[right] = tmp;

            left++;
            right--;
        }
    }

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)
            return;

        if (k > nums.length){  //如果移动的k steps 比 数组的长度还大，说明会循环一个完整的回合，变成原数组，再继续向右移动rotate
            k = k % nums.length;  //直接去余数，作为几次循环后的 移动的步数
        }

        reserve(nums, 0, nums.length-k-1);
        reserve(nums, nums.length-k, nums.length-1);
        reserve(nums, 0, nums.length-1);

    }

    public static void main(String[] args) {
        int[]test = {1,2,3,4,5,6,7};
        rotate(test,3);
        System.out.println(Arrays.toString(test));
    }
}