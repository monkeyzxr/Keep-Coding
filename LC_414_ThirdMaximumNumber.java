/**
 * Created by monkeyzxr on 2017/5/24.
 *
 Given a non-empty array of integers, return the third maximum number in this array.
 If it does not exist, return the maximum number. The time complexity must be in O(n).

 Example 1:
 Input: [3, 2, 1]
 Output: 1
 Explanation: The third maximum is 1.

 Example 2:
 Input: [1, 2]
 Output: 2
 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

 Example 3:
 Input: [2, 2, 3, 1]
 Output: 1
 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.
 *
 */

//思路：用三个变量first, second, third来分别保存第一大，第二大，和第三大的数，
// 然后我们遍历数组，如果遍历到的数字大于当前第一大的数first，那么三个变量各自错位赋值，
// 如果当前数字大于second，小于first，那么就更新second和third，
// 如果当前数字大于third，小于second，那就只更新third。

//注意这里有个坑，就是初始化要用长整型long的最小值，
//否则当数组中有INT_MIN存在时，程序就不知道该返回INT_MIN还是最大值first了
//所以，要找一个比Int的min还要小的数，当初始化的赋值

public class LC_414_ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;     // first is the max integer
        long second = Long.MIN_VALUE;   // second is the second max integer
        long third = Long.MIN_VALUE;     // third is the third max integer

        for (int num : nums){
            if(num > first){    // 3个数，整体向右移。每次都从最小的数开始重新赋值。
                third = second;
                second = first;
                first = num;
            }
            else if(num > second && num < first){ //后两个数向右移
                third = second;
                second = num;
            }
            else if (num > third && num < second){  //只后一个数向右移
                third = num;
            }
        }

        if(third == Long.MIN_VALUE)
            return (int)first;     //如果没有第三小的int
        else
            return (int)third;
    }

    public static void main(String[] args) {
        int[]test1 = {3, 2, 1};
        System.out.println(thirdMax(test1));

        int[]test2 = {1, 2};
        System.out.println(thirdMax(test2));

        int[]test3 = {2, 2, 3, 1};
        System.out.println(thirdMax(test3));


    }
}
