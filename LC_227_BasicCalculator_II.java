import java.util.Stack;

/**
 * Created by monkeyzxr on 2017/7/19.
 *
 Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Some examples:
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 Note: Do not use the eval built-in library function.


 */

/*http://www.cnblogs.com/grandyang/p/4601208.html

使用一个栈保存数字，

如果该数字之前的符号是加或减，那么把当前数字压入栈中，
注意如果是减号，则加入当前数字的相反数，因为减法相当于加上一个相反数。

如果之前的符号是乘或除，那么从栈顶取出一个数字和当前数字进行乘或除的运算，再把结果压入栈中，
那么完成一遍遍历后，所有的乘或除都运算完了，再把栈中所有的数字都加起来就是最终结果了。
 */
//https://discuss.leetcode.com/topic/16935/share-my-java-solution
    //http://www.cnblogs.com/grandyang/p/4601208.html
public class LC_227_BasicCalculator_II {
    public static int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';  //遇见的符号，初始化为加号！！

        for (int i = 0; i < s.length(); i++){

            if (Character.isDigit(s.charAt(i))){ //如果遇见数字，就一直parse出这个完整的数
                num = num * 10 + s.charAt(i) - '0';
            }

            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length()-1){ //如果遇见的char不是数字，或者遇到了是最后一位的char（数字）时
                if (sign == '-'){
                    stack.push(-num);
                }
                if (sign == '+'){  //sign初始化为+，所以第一步，一定运行这里，无论第一个数字是正还是负
                    stack.push(num);
                }
                if (sign == '*'){
                    stack.push(stack.pop() * num);
                }
                if (sign == '/'){
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;  //恢复
            }
        }

        int result = 0;
        for (int i : stack){
            result += i;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate("-6+5 "));



    }
}
