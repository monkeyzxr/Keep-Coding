import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/5/25.

 Given an array nums, write a function to move all 0's to the end of it
 while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.

 */

//我写：写不下去了
    /*
public class LC_283_MoveZeroes {

    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length-1; i++)
            for(int j = 0; j < nums.length-1-i; j++){
            if (nums[i] == 0)
                swap(nums[i], nums[i+1]);
            }
    }

    public static void main(String[] args) {
        int[] test1 = {0, 1, 0, 3, 12};
        moveZeroes(test1);
        System.out.println(Arrays.toString(test1));
    }
}
*/

//重新写：
// 将非0数字依次向前移动
// 将后面空出的部分全部补0
/*
public class LC_283_MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int curr = 0;   // 当前的index

        //非零的数往前移
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[curr] = nums[i];  //非零的数往array前面写
                curr++;
            }
        }

        //后面的元素全部补零
        for (int i = curr; i < nums.length; i++)
            nums[i] = 0;

    }

    public static void main(String[] args) {
        int[] test1 = {0, 1, 0, 3, 12};
        moveZeroes(test1);
        System.out.println(Arrays.toString(test1));
    }
}
*/


// 不是很好理解

//网上例子：http://fisherlei.blogspot.com/2015/10/leetcode-move-zeroes-solution.html
//典型的双指针问题。
//使用两个指针遍历数组，一个指向数值为0的元素，另一个指向数值不为0的元素，
// 在遍历的过程中，不断交换两个指针的值。
    /*
public class LC_283_MoveZeroes {
    public static void moveZeroes(int[] nums) {
        for (int zero_index = 0, non_zero_index = 0; zero_index < nums.length && non_zero_index < nums.length;){ // && 同时满足
            if(nums[zero_index] != 0){
                ++zero_index;                  ////
                non_zero_index = zero_index;  //
                continue;
            }
            if (nums[non_zero_index] == 0){
                non_zero_index++;
                continue;
            }
            int tmp = nums[zero_index];
            nums[zero_index] = nums[non_zero_index];
            nums[non_zero_index] = tmp;

            zero_index++;
            non_zero_index++;
        }
    }

    public static void main(String[] args) {
        int[] test1 = {0, 1, 0, 3, 12};
        moveZeroes(test1);
        System.out.println(Arrays.toString(test1));

        int[] test2 = {1, 0};
        moveZeroes(test2);
        System.out.println(Arrays.toString(test2));

        int[] test3 = {0,0,0,3,1,0,6};
        moveZeroes(test3);
        System.out.println(Arrays.toString(test3));

        int[] test4 = {0,2,0,3,0,4,0,5,0,6,0,0,7};
        moveZeroes(test4);
        System.out.println(Arrays.toString(test4));


    }
}
*/

// 我觉得挺难理解的解法

//网上的写法：http://www.cnblogs.com/grandyang/p/4822732.html
// 这道题让我们将一个给定数组中所有的0都移到后面，把非零数前移，要求不能改变非零数的相对应的位置关系，而且不能拷贝额外的数组，
// 那么只能用替换法in-place来做，
// 需要用两个指针，一个不停的向后扫，找到非零位置，然后和前面那个指针交换位置即可，参见下面的代码：
public class LC_283_MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != 0){   //找到了一个非零的数
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;

                j++;  //j是去找0 的 index
            }

        }
    }

    public static void main(String[] args) {
        int[] test1 = {0, 1, 0, 3, 12};
        moveZeroes(test1);
        System.out.println(Arrays.toString(test1));

        int[] test2 = {1, 0};
        moveZeroes(test2);
        System.out.println(Arrays.toString(test2));

        int[] test3 = {0,0,0,3,1,0,6};
        moveZeroes(test3);
        System.out.println(Arrays.toString(test3));

        int[] test4 = {0,2,0,3,0,4,0,5,0,6,0,0,7};
        moveZeroes(test4);
        System.out.println(Arrays.toString(test4));


    }
}