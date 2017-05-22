import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/5/21.
 *
 Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

 Example 1:
 Input: [1,4,3,2]
 Output: 4

 Explanation: n is 2, and the maximum sum of pairs is 4.
 Note:

 n is a positive integer, which is in the range of [1, 10000].
 All the integers in the array will be in the range of [-10000, 10000].
 *
 */



/*
本题要求： 把一个array两两分割成一组，共n组，取每一组中最小值，相加求和，使和最大。
         Sm = min(a1, b1) + min(a2, b2) + ... + min(an, bn)
我的思路: 把array sort，取第0，2，4，6......的index的value相加，就是结果。
1，4，2，3 => 1，2，3，4 => 1+3=4 就是最终结果。
原因：由于我们要最大化每对中的较小值之和，那么肯定是每对中两个数字大小越接近越好，
因为如果差距过大，而我们只取较小的数字，那么大数字就浪费掉了。
明白了这一点，我们只需要给数组排个序，然后按顺序的每两个就是一对，我们取出每对中的第一个数即为较小值累加起来即可。
*/

public class LC_561_ArrayPartitionI {
    public static int arrayPairSum(int[] nums) {
        // sorting array
        Arrays.sort(nums); //Arrays class contains various methods for manipulating arrays (such as sorting and searching).
                           // Sorts the specified array into ascending numerical order.

        int sum = 0;
        for(int i = 0; i < nums.length; i = i+2) {
            sum = sum + nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test = {1,4,3,2};
        System.out.println(arrayPairSum(test));
    }
}

/*
.length is a one-off property of Java. It's used to find the size of a single dimensional array.

.length() is a method. It's used to find the length of a String.
 */