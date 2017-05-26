import java.util.Arrays;

/**
 * Created by monkeyzxr on 2017/5/25.
 *
 Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.
 */


//我写： 写不下去了
    /*
public class LC_66_PlusOne {
    public static int[] plusOne(int[] digits) {
        int number = 0;
        for (int i = 0; i < digits.length; i++){
            number += digits[i] * Math.pow((double)10, (double)(digits.length - 1 - i));
        }
     //   System.out.println("The decimal number is : " + number);
        number = number + 1;

        if (number )


        //int [] result = new result[]



       // return null;
    }

    public static void main(String[] args) {
        int[] test1 = {1,2,4,6,9};
        plusOne(test1);
    }
}
*/


    //重新写。不能转换成十进制数，再加一。
public class LC_66_PlusOne {
    public static int[] plusOne(int[] digits) {
        if (digits == null)
            return null;

        //check if all digits are 9
        boolean allNine = true;
        for (int digit : digits){
            if (digit != 9)
                allNine = false;
        }

        if (allNine){  //全是9，则结果的array长度加一。把第一个元素设置为1，其他位上的元素都是0
            int[] result = new int[digits.length+1];
            result[0] = 1;  //the most significant digit 设置为1 ，其他位的为0
            return result;
        }
        else {
            for (int i = digits.length-1; i >= 0; i--){  //从十进制数的个位开始
                if (digits[i] < 9 ){   //例如： 382692
                    digits[i]++;    //这个位上的数加一
                    break;   // 非9的数加一，不进位。直接终止循环，其他位的数不变。
                }
                else {              //例如 ： 1999
                    digits[i] = 0;  // 如果当前位上的数是9，则进位（到下一个循环），当前位变成0
                }
            }
        }
        return  digits;
    }

    public static void main(String[] args) {
        int[] test1 = {1,2,4,6,9};
        System.out.println(Arrays.toString(plusOne(test1)));

        int[] test2 = {1,9,9,9,9};
        System.out.println(Arrays.toString(plusOne(test2)));

        int[] test3 = {9,9,9};
        System.out.println(Arrays.toString(plusOne(test3)));
    }
}
