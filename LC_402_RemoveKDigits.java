import java.util.Stack;

/**
 * Created by monkeyzxr on 2017/8/19.
 *
 Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

 Note:
 The length of num is less than 10002 and will be ≥ k.
 The given num does not contain any leading zero.

 Example 1:
 Input: num = "1432219", k = 3
 Output: "1219"
 Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

 Example 2:
 Input: num = "10200", k = 1
 Output: "200"
 Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

 Example 3:
 Input: num = "10", k = 2
 Output: "0"
 Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 */

//题目大意：给定一个用字符串表示的非负整数num，从中移除k位数字，使得剩下的数字尽可能小。

//https://discuss.leetcode.com/topic/59646/straightforward-java-solution-using-stack
public class LC_402_RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";

        Stack<Character> stack = new Stack<>(); //stack里存放最小的值，num.length - k 个数字
        int i = 0;
        while (i < num.length()){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        // corner case like "1111"
        while (k > 0){
            stack.pop();
            k--;
        }

        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();

        //remove all the 0 at the head
        while (sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));

    }
}
