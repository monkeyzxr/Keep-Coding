import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by monkeyzxr on 2017/8/17.
 *
 Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 *
 */

/*http://www.programcreek.com/2014/02/leetcode-largest-number-java/
This problem can be solve by simply sorting strings, not sorting integer.
Define a comparator to compare strings by concat() right-to-left or left-to-right.
 */
public class LC_179_LargestNumber {
    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            arr[i] = String.valueOf(nums[i]);   //int array 转换成 String array
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2); //按照降序排列？？？？？？？？
            }
        });
        //Compares its two arguments for order.
        // Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.

        StringBuilder sb = new StringBuilder();
        for (String s : arr){
            sb.append(s);
        }

        while (sb.charAt(0) == '0' && sb.length() > 1){
            sb.deleteCharAt(0);
        }

        return sb.toString();


    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));

    }
}
