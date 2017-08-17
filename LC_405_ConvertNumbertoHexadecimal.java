/**
 * Created by monkeyzxr on 2017/8/16.
 *
 Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

 Note:

 All letters in hexadecimal (a-f) must be in lowercase.
 The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0';
 otherwise, the first character in the hexadecimal string will not be the zero character.
 The given number is guaranteed to fit within the range of a 32-bit signed integer.
 You must not use any method provided by the library which converts/formats the number to hex directly.
 Example 1:

 Input:
 26

 Output:
 "1a"


 Example 2:

 Input:
 -1

 Output:
 "ffffffff"
 *
 */

//数字0到9和字母A到F（或a~f）表示，其中:A~F表示10~15，这些称作十六进制数字。

//http://blog.csdn.net/styshoo/article/details/53107560
    /*
    既然是得到十六进制，那么每次 与(&)上 0xF（二进制就是1111），得到一个值，
    然后数字向右移动4位，这里需要注意的是数字是有符号的，刚好可以利用Java提供的无符号移动>>>。

    对于：>>> 无符号右移，忽略符号位，空位都以0补齐
    无符号右移的规则只记住一点：忽略了符号位扩展，0补最高位  无符号右移运算符>>> 只是对32位和64位的值有意义
     */

    //官方解释
    //https://discuss.leetcode.com/topic/65028/java-clean-code-with-explanations-and-running-time-2-solutions/2
public class LC_405_ConvertNumbertoHexadecimal {
    public static String toHex(int num) {
        if (num == 0) return "0";
        char [] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String res = "";

        while (num != 0){
            res = map[num & 0xF] + res;
            //>>> is used to right-shifted `4` bit positions with zero-extension. The zero-extension will naturally deal with negative number.
            num = num >>>4;
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(toHex(26));

    }
}
