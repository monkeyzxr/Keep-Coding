import java.util.Stack;

/**
 * Created by monkeyzxr on 2017/7/18.
 *
 Implement a basic calculator to evaluate a simple expression string.

 The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

 You may assume that the given expression is always valid.

 Some examples:
 "1 + 1" = 2
 " 2-1 + 2 " = 3
 "(1+(4+5+2)-3)+(6+8)" = 23
 Note: Do not use the eval built-in library function.
 *
 */

//用Stack
/*
我们需要一个栈来辅助计算，
用个变量sign来表示当前的符号，我们遍历给定的字符串s，如果遇到了数字，由于可能是个多位数，所以我们要用while循环把之后的数字都读进来，
然后用sign*num来更新结果res；

如果遇到了加号，则sign赋为1，如果遇到了符号，则赋为-1；

如果遇到了左括号，则把当前结果res和符号sign压入栈，res重置为0，sign重置为1；

如果遇到了右括号，结果res乘以栈顶的符号，栈顶元素出栈，结果res加上栈顶的数字，栈顶元素出栈。
 */

//http://blog.csdn.net/xudli/article/details/46554835
//http://www.cnblogs.com/grandyang/p/4570699.html
public class LC_224_BasicCalculator {
    public static int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int sign = 1; //指定正负号, 初始化为正号

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            //如果遇到的char是个数字，则parse整个数字
            if (Character.isDigit(c)){
                int cur = c - '0';
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    cur = 10 * cur + s.charAt(++i) -'0';

                    //或者：
                    //sum = sum * 10 + s.charAt(i + 1) - '0';
                   //  i++;
                }
                res += sign * cur;
            }
            else if (c == '-'){
                sign = -1;
            }
            else if (c == '+'){
                sign = 1;
            }
            else if (c == '('){
                stack.push(res); //先push res
                res = 0;
                stack.push(sign);  //再push sign
                sign = 1;
            }
            else if (c == ')'){
                //pop out the top two numbers from stack,
                // first one is the sign before this pair of parenthesis,
                // second is the temporary result before this pair of parenthesis.
                // We add them together.
                res = stack.pop() * res + stack.pop();
                sign = 1;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(calculate("2-1 + 2"));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));


    }
}

/*
https://discuss.leetcode.com/topic/15816/iterative-java-solution-with-stack

Simple iterative solution by identifying characters one by one. One important thing is that the input is valid, which means the parentheses are always paired and in order.
Only 5 possible input we need to pay attention:

digit: it should be one digit from the current number
'+': number is over, we can add the previous number and start a new number
'-': same as above
'(': push the previous result and the sign into the stack, set result to 0, just calculate the new result within the parenthesis.
')': pop out the top two numbers from stack, first one is the sign before this pair of parenthesis, second is the temporary result before this pair of parenthesis. We add them together.
Finally if there is only one number, from the above solution, we haven't add the number to the result, so we do a check see if the number is zero.
 */