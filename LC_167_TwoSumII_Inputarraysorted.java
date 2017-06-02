import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/6/1.
 *
 Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution and you may not use the same element twice.

 Input: numbers={2, 7, 11, 15}, target=9  //这个例子不对，input要是sorted的array
 Output: index1=1, index2=2
 *
 *
 *
 */

//因为已经sorted了。
//思路：两个指针，一个指向开头，一个指向末尾，然后向中间遍历，
// 如果指向的两个数相加正好等于target的话，直接返回两个指针的位置即可，
// 若小于target，左指针右移一位，
// 若大于target，右指针左移一位，以此类推直至两个指针相遇停止，

//http://www.programcreek.com/2014/03/two-sum-ii-input-array-is-sorted-java/
public class LC_167_TwoSumII_Inputarraysorted {
    public static int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];

        int left = 0;
        int right = numbers.length-1;

        while (left <right){
            if (numbers[left] + numbers[right] == target){
                index[0] = left + 1;   //题目中的index是从1开始数的
                index[1] = right + 1;
                break;   //必须break，不然虽然找到结果，却跳不出循环！
            }
            else if (numbers[left] + numbers[right] > target) {
                right--;
            }

            else if (numbers[left] + numbers[right] < target){
                left++;
            }

        }
        return index;
    }

    public static void main(String[] args) {
        int[]test1 = {2,5,7,11};
        System.out.println(Arrays.toString(twoSum(test1,9)));

        int[]test2 = {0,0,0,0,0,0};
        System.out.println(Arrays.toString(twoSum(test2,0)));

        int[]test3 = {3,4,5,6,7};
        System.out.println(Arrays.toString(twoSum(test3,11)));
    }
}
