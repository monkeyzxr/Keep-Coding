/**
 * Created by monkeyzxr on 2017/7/21.
 *
 Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 Update (2015-02-10):
 The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

 spoilers alert... click to show requirements for atoi.

 Requirements for atoi:
 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 *
 */

/*http://blog.csdn.net/ljiabin/article/details/40508889
解释一下题目的要求：

1. 首先需要丢弃字符串前面的空格；

2. 然后可能有正负号（注意只取一个，如果有多个正负号，那么说这个字符串是无法转换的，返回0。比如测试用例里就有个“+-2”）；

3. 字符串可以包含0~9以外的字符，如果遇到非数字字符，那么只取该字符之前的部分，如“-00123a66”返回为“-123”；

4. 如果超出int的范围，返回边界值（2147483647或-2147483648）。
 */

//http://www.jiuzhang.com/solutions/string-to-integer-atoi/
public class LC_8_StringtoInteger_atoi {
    public static int myAtoi(String str) {
        if (str == null)
            return 0;

        // returns a copy of the string, with leading and trailing whitespace omitted.
        str = str.trim();
        if (str.length() == 0)
            return 0;

        int sign = 1;  //确定正负号
        int index = 0;

        if (str.charAt(index) == '+')
            index++;
        else if (str.charAt(index) == '-'){
            sign = -1;
            index++;
        }

        long num = 0;
        for (; index < str.length(); index++){
            if (str.charAt(index) < '0' || str.charAt(index) > '9')  //每一次循环都要判断。例如，如果连续两个正号，则退出循环，返回num = 0
                break;

            num = num * 10 + (str.charAt(index) - '0');  //parse 整个数字

            if (num > Integer.MAX_VALUE)  //然后判断当前num的大小是否越界
                break;
        }

        if (num * sign >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (num * sign <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)num * sign;

    }

    public static void main(String[] args) {
        System.out.println(myAtoi("+-2"));
        System.out.println(myAtoi("+200"));
        System.out.println(myAtoi("-200"));



    }
}
