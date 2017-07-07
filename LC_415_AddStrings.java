/**
 * Created by monkeyzxr on 2017/7/5.
 *
 Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

 Note:

 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */

//https://discuss.leetcode.com/topic/62310/straightforward-java-8-main-lines-25ms
public class LC_415_AddStrings {
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length()-1, j = num2.length()-1; i >= 0 || j >= 0; i--, j--){
            /*
             int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
             */
            int digit1, digit2;
            if (i >= 0 )
                digit1 = num1.charAt(i) - '0';
            else
                digit1 = 0;

            if (j >= 0)
                digit2 = num2.charAt(j) - '0';
            else
                digit2 = 0;

            sb.append((digit1+digit2+carry) % 10);
            carry = (digit1+digit2+carry) / 10;
        }

        if (carry != 0)
            sb.append(carry);

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "2";

        System.out.println(addStrings(num1, num2));

    }
}
