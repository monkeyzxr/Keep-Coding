/**
 * Created by monkeyzxr on 2017/7/18.
 *
 Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

 Note:

 The length of both num1 and num2 is < 110.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */

//http://www.jiuzhang.com/solutions/multiply-strings/
    //http://www.programcreek.com/2014/05/leetcode-multiply-strings-java/

    //这个有很好的图示意：
    //https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation
public class LC_43_MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null)
            return null;

        //把原来String 反向，为了从最右位的数字开始相乘。
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int [] digit = new int[num1.length()+num2.length()];  //两数乘积最长也就是两个数个数的和。如： 99*99 = 9801

        //multiply each digit and sum at the corresponding positions
        for (int i = 0; i < n1.length(); i++){
            for (int j = 0; j < n2.length(); j++){
                digit[i+j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();

        //calculate each digit
        for (int i = 0; i < digit.length; i++){
            int mod = digit[i] % 10;

            int carry = digit[i] / 10;
            if (i+1 < digit.length){
                digit[i+1] += carry;  //把进位的carry加入到下一位中
            }

            sb.insert(0, mod); //inserted into the contents of this sequence at the position indicated by offset.
        }

        //remove front 0's
        while (sb.charAt(0) == '0' && sb.length() > 1)
            sb.deleteCharAt(0);

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(multiply("11", "10"));

        System.out.println(multiply("99", "99"));

    }
}
