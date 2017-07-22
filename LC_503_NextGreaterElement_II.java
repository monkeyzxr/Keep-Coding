import java.util.Arrays;
import java.util.Stack;

/**
 * Created by monkeyzxr on 2017/7/21.
 *
 Given a circular array (the next element of the last element is the first element of the array),
 print the Next Greater Number for every element.
 The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
 which means you could search circularly to find its next greater number.
 If it doesn't exist, output -1 for this number.

 Example 1:
 Input: [1,2,1]
 Output: [2,-1,2]
 Explanation: The first 1's next greater number is 2;
 The number 2 can't find next greater number;
 The second 1's next greater number needs to search circularly, which is also 2.

 Note: The length of given array won't exceed 10000.
 *
 */

/*
http://www.cnblogs.com/grandyang/p/6442861.html
数组是一个循环数组，就是说某一个元素的下一个较大值可以在其前面，
那么对于循环数组的遍历，为了使下标不超过数组的长度，我们需要对n取余，
下面先来看暴力破解的方法，遍历每一个数字，然后对于每一个遍历到的数字，遍历所有其他数字，
注意不是遍历到数组末尾，而是通过循环数组遍历其前一个数字，遇到较大值则存入结果res中，并break，再进行下一个数字的遍历
 */

/*
public class LC_503_NextGreaterElement_II {
    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1); //初始化
                                                //    i  j
        for (int i = 0; i < nums.length; i++){  // 1  2  3   4  5  6  7
            for (int j = i+1; j < i+nums.length; j++){        //??????????????
                if (nums[j%nums.length] > nums[i]){        //????????????????为了使下标不超过数组的长度，我们需要对n取余
                    result[i] = nums[j%nums.length];
                    break;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
*/

/*
http://www.cnblogs.com/grandyang/p/6442861.html
我们可以使用栈来进行优化上面的算法，
我们遍历两倍的数组，然后还是坐标i对n取余，取出数字，
如果此时栈不为空，且栈顶元素小于当前数字，说明当前数字就是栈顶元素的右边第一个较大数，那么建立二者的映射，并且去除当前栈顶元素，
最后如果i小于n，则把i压入栈。因为res的长度必须是n，超过n的部分我们只是为了给之前栈中的数字找较大值，所以不能压入栈
 */

//http://blog.csdn.net/cloudox_/article/details/62881181
public class LC_503_NextGreaterElement_II {
    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1); //初始化

        Stack<Integer> stack = new Stack<>();  //stack 里面存放的是index

        for (int i = 0; i < 2*nums.length; i++){
            int num = nums[i%nums.length];  //当前数字

            while (!stack.isEmpty() && nums[stack.peek()] < num){
                result[stack.peek()] = num;  //建立关系：当栈的顶端index对应的值 小于 当前的num，则栈顶端的index对应值的右侧大元素是 当前的num
                stack.pop(); //已经找到当前的一个结果了，则去除当前栈顶元素
            }

            if (i < nums.length)
                stack.push(i);
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}