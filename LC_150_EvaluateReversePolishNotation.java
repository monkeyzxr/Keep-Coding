import java.util.Stack;

/**
 * Created by monkeyzxr on 2017/8/26.
 *
 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

/*https://zh.wikipedia.org/wiki/%E9%80%86%E6%B3%A2%E5%85%B0%E8%A1%A8%E7%A4%BA%E6%B3%95
逆波兰记法中，操作符置于操作数的后面。
例如表达“三加四”时，写作“3 4 +”，而不是“3 + 4”。
如果有多个操作符，操作符置于第二个操作数的后面，所以常规中缀记法的“3 - 4 + 5”在逆波兰记法中写作“3 4 - 5 +”：先3减去4，再加上5。
使用逆波兰记法的一个好处是不需要使用括号。例如中缀记法中“3 - 4 * 5”与“（3 - 4）*5”不相同，但后缀记法中前者写做“3 4 5 * -”，无歧义地表示“3 (4 5 *) -”；后者写做“3 4 - 5 *”。

 逆波兰表达式的解释器一般是基于堆栈的。
 解释过程一般是：操作数入栈；遇到操作符时，操作数出栈，求值，将结果入栈；
 当一遍后，栈顶就是表达式的值。因此逆波兰表达式的求值使用堆栈结构很容易实现，并且能很快求值。

 例子:
中缀表达式“5 + ((1 + 2) * 4) − 3”写作
5 1 2 + 4 * + 3 −
下表给出了该逆波兰表达式从左至右求值的过程，堆栈栏给出了中间值，用于跟踪算法。
输入	操作	      堆栈	           注释
5	入栈      	5
1	入栈	        5, 1
2	入栈	        5, 1, 2
+	加法运算	    5, 3	       (1, 2)出栈；将结果（3）入栈
4	入栈       	5, 3, 4
*	乘法运算   	5, 12	       (3, 4)出栈；将结果（12）入栈
+	加法运算  	17	           (5, 12)出栈；将结果 (17)入栈
3	入栈	        17, 3
−	减法运算	    14	           (17, 3)出栈；将结果（14）入栈
计算完成时，栈内只有一个操作数，这就是表达式的结果：14
 */


//http://www.jiuzhang.com/solutions/evaluate-reverse-polish-notation/
//https://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
//http://blog.csdn.net/DERRANTCM/article/details/47801765


public class LC_150_EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String operators = "+-*/";

        for (String token: tokens){
            if (!operators.contains(token)){
                stack.push(Integer.valueOf(token));
                continue;
            }
            int a = stack.pop();
            int b = stack.pop();

            if (token.equals("+")){
                stack.push(b + a);
            }
            else if (token.equals("-")){
                stack.push(b - a);
            }
            else if (token.equals("*")){
                stack.push(b * a);
            }
            else {
                stack.push(b / a);
            }
        }

        return stack.pop();

    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));

    }
}
